package com.sainsburys.transformers.SalesConsumer.Adapters;

import com.sainsburys.transformers.SalesConsumer.KafkaListener.KafkaConsumer;
import io.confluent.developer.avro.RawSales;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.sql.*;

public class Insert_SA_BASKET_HEAD {

    private static final Logger LOGGER = LoggerFactory.getLogger(Insert_SA_BASKET_HEAD.class);

    // private boolean commitOffsets;

    @Autowired
    //public JdbcTemplate jdbcTemplate;
    private RawSales rawSales ;


    public Insert_SA_BASKET_HEAD(Connection conn, Long STOREID) throws SQLException {


       //Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
        //Connection conn = DataSourceUtils.getConnection (jdbcTemplate.getDataSource ());


        String insertSQL = "INSERT INTO RSAPPF7_OWNER.SA_BASKET_HEAD (TXN_KEY,TRADING_DATE,STORE,LOAD_DATE_TIME,TXN_DATE_TIME,TILL_BANK_ID,POS_NO,POS_TXN_NO,CASHIER_ID,TXN_VOID_IND,STY_ORDER_NUMBER,BAG_COUNT,BAG_VALUE,CUSTOMER_COUNT_IND,REPLAY_IND,REF_DATA_VERSION,NO_SALE,ACTIVE_KIDS) values (RSAPPF7_OWNER.TXN_KEY_SEQ.CURRVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}


