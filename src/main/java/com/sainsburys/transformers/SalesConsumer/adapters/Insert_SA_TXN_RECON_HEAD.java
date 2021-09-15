package com.sainsburys.transformers.SalesConsumer.adapters;

import com.acme.avro.payLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.time.OffsetDateTime;

public class Insert_SA_TXN_RECON_HEAD {
    private static final Logger LOGGER = LoggerFactory.getLogger(Insert_SA_BASKET_HEAD.class);

    // private boolean commitOffsets;

    @Autowired
    //public JdbcTemplate jdbcTemplate;
    private payLoad payload ;


    public Insert_SA_TXN_RECON_HEAD(Connection conn, Long storeId, String workStationId, Long sequencNo,  Timestamp startTransDateTime, Date tradingDayDate) throws SQLException {


        String insertSQL = "INSERT INTO RSAPPF7_OWNER.SA_RECON_TXN_HEAD_KEY(STORE,POS_NO,POS_TXN_NO,TXN_DATE_TIME,TXN_KEY,TRADING_DATE) VALUES(?,?,?,?,RSAPPF7_OWNER.TXN_KEY_SEQ.NEXTVAL,?)" ;
        PreparedStatement psInsert = conn.prepareStatement(insertSQL);





        // psInsert.setLong(1,9999);
        psInsert.setLong(1, storeId);
        psInsert.setLong(2, Integer.parseInt(workStationId));
        psInsert.setLong(3, sequencNo);
        //psInsert.setDate(4, Date.valueOf("2021-07-14"));
        psInsert.setDate(4,  tradingDayDate);
        psInsert.setTimestamp(5,  startTransDateTime);

        System.out.println("insert sql  " + insertSQL);

        try {
            psInsert.execute();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
