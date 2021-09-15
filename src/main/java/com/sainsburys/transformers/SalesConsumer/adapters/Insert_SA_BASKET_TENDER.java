package com.sainsburys.transformers.SalesConsumer.adapters;

import com.acme.avro.payLoad;
import com.acme.avro.tenderTypes_record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class Insert_SA_BASKET_TENDER {
    private static final Logger LOGGER = LoggerFactory.getLogger(Insert_SA_BASKET_HEAD.class);

    // private boolean commitOffsets;

    @Autowired
    //public JdbcTemplate jdbcTemplate;
    private payLoad payload ;
    private tenderTypes_record tender;


    public Insert_SA_BASKET_TENDER(Connection conn, Long STOREID) throws SQLException {


        String insertSQL = "INSERT INTO RSAPPF7_OWNER.SA_BASKET_TENDER(TXN_TENDER_KEY,TXN_KEY, TRADING_DATE, STORE, LOAD_DATE_TIME, TENDER_TYPE_ID, " +
               " CANCEL_ITEM_IND, SUBTRACT_ITEM_IND, TENDER_VALUE,  MONETARY_CHANGE,CONV_RATE , OTHER_VALUE) " +
                "VALUES(,RSAPPF7_OWNER.TXN_TENDER_KEY_SEQ.NEXTVAL,TXN_KEY_SEQ.CURRVAL,?,?,?,?,?,?,?,?,?,?)" ;
        PreparedStatement psInsert = conn.prepareStatement(insertSQL);





        psInsert.setTimestamp(5, (Timestamp) payload.getTradingDayDate());
        psInsert.setLong(1, STOREID);
        psInsert.setDate(4, (Date) payload.getStartTransDateTime());
        psInsert.setLong(2, Integer.parseInt(String.valueOf(tender.getTenderType())));
        psInsert.setString(4, "N");
        psInsert.setString(4, "N");
        psInsert.setDouble(4, Double.parseDouble((String) tender.getAmount()));
        psInsert.setDouble(4, 0.00);
        psInsert.setDouble(4, 0.00);
        psInsert.setDouble(4, 0.00);


        System.out.println("insert sql  " + insertSQL);

        try {
            psInsert.execute();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
