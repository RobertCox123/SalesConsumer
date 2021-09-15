package com.sainsburys.transformers.SalesConsumer.adapters;

import com.acme.avro.payLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class Insert_SA_BASKET_SUBTOTAL {
    private static final Logger LOGGER = LoggerFactory.getLogger(Insert_SA_BASKET_PROM_ITEM.class);

    // private boolean commitOffsets;

    @Autowired
    //public JdbcTemplate jdbcTemplate;
    private payLoad payload ;


    public Insert_SA_BASKET_SUBTOTAL(Connection conn, Long STOREID, Date tradingDayDate, Timestamp loaddate, Double totalQuantity, Double totalNetAmount) throws SQLException {


        String insertSQL = "INSERT INTO  RSAPPF7_OWNER.SA_BASKET_SUBTOTAL(TXN_SUB_TOTAL_KEY, TXN_KEY, TRADING_DATE, STORE, LOAD_DATE_TIME, ITEM_COUNT,  SUB_TOTAL_VALUE )" +
                " VALUES (RSAPPF7_OWNER.TXN_SUB_TOTAL_KEY_SEQ.NEXTVAL, RSAPPF7_OWNER.TXN_KEY_SEQ.CURRVAL, RSAPPF7_OWNER.TXN_PROM_KEY_SEQ.CURRVAL, ?, ?, ?, ?, ?)";
        PreparedStatement psInsert = conn.prepareStatement(insertSQL);





        // psInsert.setLong(1,9999);
        psInsert.setDate(1, tradingDayDate);
        psInsert.setLong(2, STOREID);
        psInsert.setTimestamp(3, loaddate);
        psInsert.setDouble (4, totalQuantity);
        psInsert.setDouble(5, totalNetAmount);




        System.out.println("insert sql  " + insertSQL);

        try {
            psInsert.execute();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
