package com.sainsburys.transformers.SalesConsumer.KafkaListener;

import com.acme.avro.STSSales;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sainsburys.transformers.SalesConsumer.Model.Converter;
import com.sainsburys.transformers.SalesConsumer.Model.LineItem;
import com.sainsburys.transformers.SalesConsumer.Model.Salesmessage;
import com.sainsburys.transformers.SalesConsumer.adapters.Insert_SA_BASKET_HEAD;
import com.sainsburys.transformers.SalesConsumer.adapters.Insert_SA_BASKET_ITEM;
import com.sainsburys.transformers.SalesConsumer.adapters.Insert_SA_BASKET_SUBTOTAL;
import com.sainsburys.transformers.SalesConsumer.adapters.Insert_SA_TXN_RECON_HEAD;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//import java.sql.*;

import java.io.IOException;
import java.sql.*;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


@EnableKafka
@Service



public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private boolean commitOffsets;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //public STSSales sales;


    //Connection connection = dataSource.getConnection();
    //connection.setAutoCommit(false);
    public KafkaConsumer() throws SQLException {
    }


    @KafkaListener(topics = "${topic_name}", groupId = "${consumer_group_id}", containerFactory = "kafkaListenerContainerFactory")

    public void listen(ConsumerRecord<String, STSSales> record) throws SQLException {
        LOGGER.info(String.format("Consumed message -> %s", record.value()));
        Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
        try {
            // build Recon Header
            Salesmessage data = Converter.fromJsonString(String.valueOf(record.value()));
            String partnerid = data.getPartnerID();
            System.out.println("partnerid" +partnerid );
            Long storeId = data.getStoreID();
            System.out.println("storeId" +storeId );
            String workStationId = data.getPayLoad().getWorkstationID();
            System.out.println("workStationId" +workStationId );
            Long sequenceNo = data.getPayLoad().getSequenceNumber();
            System.out.println("sequenceNo" +sequenceNo );
            OffsetDateTime StartTransDateTime = data.getPayLoad().getStartTransDateTime();
            Timestamp loaddate =Timestamp.valueOf(StartTransDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
            Date TradingDayDate = Date.valueOf(data.getPayLoad().getTradingDayDate());
            // Insert Recon Header
            //Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            System.out.println("Connection : " +conn );
            LOGGER.info("Inserting trans header");
            Insert_SA_TXN_RECON_HEAD recon = new Insert_SA_TXN_RECON_HEAD(conn,storeId, workStationId, sequenceNo, loaddate, TradingDayDate );

            // build Basket header
            //String basketEan = data.getPayLoad().getTransaction().getLineItems()[0].getEanNumber();
            // Insert Basket Header
            LOGGER.info("Inserting basket header");
            Insert_SA_BASKET_HEAD baskethead = new Insert_SA_BASKET_HEAD(conn,storeId,TradingDayDate,loaddate, workStationId, sequenceNo);

            // build subtotals


            Double totalQuantity = Double.valueOf(data.getPayLoad().getTotalQuantity());
            Double totalNetAmount = Double.valueOf(data.getPayLoad().getTotalNetAmount());

            LOGGER.info("Inserting subtotals");
            Insert_SA_BASKET_SUBTOTAL subtotals = new Insert_SA_BASKET_SUBTOTAL(conn,storeId,TradingDayDate,loaddate, totalQuantity, totalNetAmount);



            // loop over line items
            int index = 0 ;
            for (LineItem i  : data.getPayLoad().getTransaction().getLineItems()) {

                String eanNumber = data.getPayLoad().getTransaction().getLineItems()[index].getEanNumber();
                String posItemId = data.getPayLoad().getTransaction().getLineItems()[index].getPosItemID();
                Double extendedValue = Double.valueOf(data.getPayLoad().getTransaction().getLineItems()[index].getExtendedValue());
                System.out.println ( "ean number :" +eanNumber);
                System.out.println ( "SKU :" +posItemId);
                System.out.println ( "extendedValue :" +extendedValue);
                Integer quantity  = Integer.valueOf((data.getPayLoad().getTransaction().getLineItems()[index].getQuantity()));
                System.out.println ( "quantity :" +quantity);
                Double unitPrice  = Double.valueOf(data.getPayLoad().getTransaction().getLineItems()[index].getUnitPrice());
                System.out.println ( "unitPrice  :" +unitPrice );
                String scanData = data.getPayLoad().getTransaction().getLineItems()[index].getScanData();
                System.out.println ( "scanData  :" +scanData );
                String returnCode = data.getPayLoad().getTransaction().getLineItems()[index].getReturnCode();
                System.out.println ( "returnCode  :" +returnCode );
                String salesGroup = data.getPayLoad().getTransaction().getLineItems()[index].getConsumableGroup();
                Long classGroup = Long.valueOf(data.getPayLoad().getTransaction().getLineItems()[index].getHierarchy().getGroupID());
                LOGGER.info("Inserting basket header");
                String lineType = data.getPayLoad().getTransaction().getLineItems()[index].getLineType();
                String fuelItem = "N";
                if (lineType == "Fuel")
                         fuelItem = "Y";

                Insert_SA_BASKET_ITEM basketitem = new Insert_SA_BASKET_ITEM(conn,storeId,TradingDayDate,loaddate, eanNumber,posItemId,extendedValue,
                        quantity, unitPrice,scanData,returnCode, salesGroup,classGroup , fuelItem);
                index = index +1;
            }








            try {
                conn.commit();
                System.out.println("Row successfully inserted ");
            } catch (SQLException e) {
                e.printStackTrace();
                conn.rollback();
            }

    } catch (IOException e) {
        e.printStackTrace();
    }



       // Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());



       /* String insertSQL = "INSERT INTO RSAPPF7_OWNER.SA_BASKET_HEAD (TXN_KEY,TRADING_DATE,STORE,LOAD_DATE_TIME,TXN_DATE_TIME,TILL_BANK_ID,POS_NO,POS_TXN_NO,CASHIER_ID,TXN_VOID_IND,STY_ORDER_NUMBER,BAG_COUNT,BAG_VALUE,CUSTOMER_COUNT_IND,REPLAY_IND,REF_DATA_VERSION,NO_SALE,ACTIVE_KIDS) values (RSAPPF7_OWNER.TXN_KEY_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement psInsert = conn.prepareStatement(insertSQL);
        // psInsert.setLong(1,9999);
        psInsert.setDate(1, Date.valueOf("2021-07-06"));
        psInsert.setLong(2, STOREID);
        psInsert.setDate(3, Date.valueOf("2021-07-14"));
        psInsert.setTimestamp(4, Timestamp.valueOf("2021-07-14 11:00:00"));
        psInsert.setLong(5, 12);
        psInsert.setLong(6, 10);
        psInsert.setLong(7, 1001);
        psInsert.setLong(8, 1234);
        psInsert.setString(9, "N");
        psInsert.setLong(10, 0);
        psInsert.setLong(11, 0);
        psInsert.setDouble(12, 0.0000);
        psInsert.setString(13, "Y");
        psInsert.setString(14, "N");
        psInsert.setString(15, "20210714-193000");
        psInsert.setLong(16, 0);
        psInsert.setLong(17, 0);
        System.out.println("insert sql  " + insertSQL);

        try {
            psInsert.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/


    }
}




