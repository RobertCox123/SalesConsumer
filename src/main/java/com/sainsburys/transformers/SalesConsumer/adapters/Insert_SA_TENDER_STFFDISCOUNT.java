package com.sainsburys.transformers.SalesConsumer.adapters;

import com.acme.avro.payLoad;
import com.acme.avro.staffDiscount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class Insert_SA_TENDER_STFFDISCOUNT{
// from Webmethods
//INSERT INTO SA_BASKET_TENDER_STFF_DSCNT(TXN_TENDER_STAFF_DISCOUNT_KEY,TXN_KEY,TXN_TENDER_KEY,TRADING_DATE,STORE,LOAD_DATE_TIME,ACCOUNT_NO,EXPIRY_DATE,SALES_VALUE,ISSUE_NO,
// DISCOUNT_RATE,STAFF_CARD_ENTRY_ID)
// VALUES(TXN_STAFF_DISCNT_KEY_SEQ.NEXTVAL,TXN_KEY_SEQ.CURRVAL,TXN_TENDER_KEY_SEQ.CURRVAL,?,?,?,?,?,?,?,?,?)

    private static final Logger LOGGER = LoggerFactory.getLogger(Insert_SA_BASKET_PROM_ITEM.class);

    // private boolean commitOffsets;

    @Autowired
    //public JdbcTemplate jdbcTemplate;



    private payLoad payload ;
    private staffDiscount staff;

    public Insert_SA_TENDER_STFFDISCOUNT(Connection conn, Long STOREID) throws SQLException {


        String insertSQL = "INSERT INTO  RSAPPF7_OWNER.SA_BASKET_TENDER_STFF_DSCNT(TXN_TENDER_STAFF_DISCOUNT_KEY,TXN_KEY,TXN_TENDER_KEY," +
                "TRADING_DATE,STORE,LOAD_DATE_TIME,ACCOUNT_NO,EXPIRY_DATE,SALES_VALUE,ISSUE_NO," +
                "DISCOUNT_RATE,STAFF_CARD_ENTRY_ID)" +
                " VALUES (RSAPPF7_OWNER.TXN_STAFF_DISCNT_KEY_SEQ.NEXTVAL,RSAPPF7_OWNER.TXN_KEY_SEQ.CURRVAL,RSAPPF7_OWNER.TXN_TENDER_KEY_SEQ.CURRVAL," +
                "?,?,?,?,?,?,?,?,?)";
        PreparedStatement psInsert = conn.prepareStatement(insertSQL);


        // psInsert.setLong(1,9999);
        psInsert.setTimestamp(5, (Timestamp) payload.getTradingDayDate());
        psInsert.setLong(2, STOREID);
        psInsert.setDate(4, (Date) payload.getStartTransDateTime()); //replace with date from Dual
        psInsert.setString(4, String.valueOf(staff.getStaffDiscountCard()));
        psInsert.setString(4, "9912");
        psInsert.setDouble(4, Double.parseDouble((String) staff.getQualifyingSpend()));
        psInsert.setInt(5, 01);
        psInsert.setDouble(4, Double.parseDouble((String) staff.getDiscountRate()));
        psInsert.setInt(5, 0);



        System.out.println("insert sql  " + insertSQL);

        try {
            psInsert.execute();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
