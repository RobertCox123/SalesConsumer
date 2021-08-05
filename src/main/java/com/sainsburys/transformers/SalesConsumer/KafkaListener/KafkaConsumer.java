package com.sainsburys.transformers.SalesConsumer.KafkaListener;

import com.sainsburys.transformers.SalesConsumer.Adapters.Insert_SA_BASKET_HEAD;
import com.sainsburys.transformers.SalesConsumer.Adapters.Insert_SA_TXN_RECON_HEAD;
import io.confluent.developer.avro.RawSales;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.sql.*;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


@EnableKafka
@Service



public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private boolean commitOffsets;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    //Connection connection = dataSource.getConnection();
    //connection.setAutoCommit(false);
    public KafkaConsumer() throws SQLException {
    }


    @KafkaListener(topics = "${topic_name}", groupId = "${consumer_group_id}", containerFactory = "kafkaListenerContainerFactory")

    public void listen(ConsumerRecord<String, RawSales> record) throws SQLException {
        LOGGER.info(String.format("Consumed message -> %s", record.value()));
        JSONParser parser = new JSONParser();

        Object obj = null;
        try {
            obj = parser.parse(String.valueOf(record.value()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;

        Long STOREID = (Long) jsonObject.get("storeId");
        System.out.println(STOREID );

        String TILL_ID = (String) jsonObject.get("tillId");
        System.out.println(TILL_ID);

        String BASKET_KEY = (String) jsonObject.get("basketKey");
        System.out.println(BASKET_KEY);
        Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
        System.out.println("Connection : " +conn );
        LOGGER.info("Inserting trans header");
        Insert_SA_TXN_RECON_HEAD recon = new Insert_SA_TXN_RECON_HEAD(conn,STOREID);

        LOGGER.info("Inserting basket header");
        Insert_SA_BASKET_HEAD baskethead = new Insert_SA_BASKET_HEAD(conn,STOREID);



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
        try {
            conn.commit();
            System.out.println("Row successfully inserted ");
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }

    }
}




