package com.sainsburys.transformers.SalesConsumer.Adapters;

import io.confluent.developer.avro.RawSales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class Insert_SA_TXN_RECON_HEAD {
    private static final Logger LOGGER = LoggerFactory.getLogger(Insert_SA_BASKET_HEAD.class);

    // private boolean commitOffsets;

    @Autowired
    //public JdbcTemplate jdbcTemplate;
    private RawSales rawSales ;


    public Insert_SA_TXN_RECON_HEAD(Connection conn, Long STOREID) throws SQLException {


        String insertSQL = "INSERT INTO RSAPPF7_OWNER.SA_RECON_TXN_HEAD_KEY(STORE,POS_NO,POS_TXN_NO,TXN_DATE_TIME,TXN_KEY,TRADING_DATE) VALUES(?,?,?,?,RSAPPF7_OWNER.TXN_KEY_SEQ.NEXTVAL,?)" ;
        PreparedStatement psInsert = conn.prepareStatement(insertSQL);





        // psInsert.setLong(1,9999);
        psInsert.setLong(1, STOREID);
        psInsert.setLong(2, 12);
        psInsert.setLong(3, 10);
        psInsert.setDate(4, Date.valueOf("2021-07-14"));
        psInsert.setTimestamp(5, Timestamp.valueOf("2021-07-14 11:00:00"));

        System.out.println("insert sql  " + insertSQL);

        try {
            psInsert.execute();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
