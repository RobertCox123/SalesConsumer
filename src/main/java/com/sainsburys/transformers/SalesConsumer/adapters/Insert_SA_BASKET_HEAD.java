package com.sainsburys.transformers.SalesConsumer.adapters;

import io.confluent.developer.avro.RawSales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.sql.*;
import java.time.LocalDate;

public class Insert_SA_BASKET_HEAD {

    private static final Logger LOGGER = LoggerFactory.getLogger(Insert_SA_BASKET_HEAD.class);

    // private boolean commitOffsets;




    public Insert_SA_BASKET_HEAD(Connection conn, Long storeId, Date tradingDayDate, Timestamp startTransDateTime, String workStationId, Long sequenceNo) throws SQLException {
        LocalDate date = LocalDate.now().minusDays(1);
        String refDataVersion = date +"-193000";




        String insertSQL = "INSERT INTO RSAPPF7_OWNER.SA_BASKET_HEAD (TXN_KEY,TRADING_DATE,STORE,LOAD_DATE_TIME,TXN_DATE_TIME,TILL_BANK_ID,POS_NO,POS_TXN_NO,CASHIER_ID,TXN_VOID_IND,STY_ORDER_NUMBER,BAG_COUNT,BAG_VALUE,CUSTOMER_COUNT_IND,REPLAY_IND,REF_DATA_VERSION,NO_SALE,ACTIVE_KIDS) values (RSAPPF7_OWNER.TXN_KEY_SEQ.CURRVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement psInsert = conn.prepareStatement(insertSQL);





        // psInsert.setLong(1,9999);
        psInsert.setDate(1, tradingDayDate);
        psInsert.setLong(2, storeId);
        psInsert.setTimestamp(3, startTransDateTime);
        psInsert.setTimestamp(4, startTransDateTime);
        psInsert.setLong(5, 90);
        psInsert.setLong(6, Long.parseLong(workStationId));
        psInsert.setLong(7, sequenceNo);
        psInsert.setLong(8, 1);
        psInsert.setString(9, "N");
        psInsert.setLong(10, 0);
        psInsert.setLong(11, 0);
        psInsert.setDouble(12, 0.0000);
        psInsert.setString(13, "Y");
        psInsert.setString(14, "N");
        psInsert.setString(15, refDataVersion);
        psInsert.setLong(16, 0);
        psInsert.setLong(17, 0);
        System.out.println("insert sql  " + insertSQL);

        try {
            psInsert.execute();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}


