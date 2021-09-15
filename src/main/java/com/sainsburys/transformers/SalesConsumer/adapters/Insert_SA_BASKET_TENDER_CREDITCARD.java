package com.sainsburys.transformers.SalesConsumer.adapters;

import com.acme.avro.payLoad;
import com.acme.avro.tenderTypes_record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class Insert_SA_BASKET_TENDER_CREDITCARD {
    private static final Logger LOGGER = LoggerFactory.getLogger(Insert_SA_BASKET_TENDER_CREDITCARD.class);

    // private boolean commitOffsets;

    @Autowired
    //public JdbcTemplate jdbcTemplate;
    private payLoad payload ;
    private tenderTypes_record tender;


    public Insert_SA_BASKET_TENDER_CREDITCARD(Connection conn, Long STOREID) throws SQLException {

        String paymentCardInd = "18";
        if (String.valueOf(tender.getTenderType()) == "Cash") paymentCardInd = "1";
           else if (String.valueOf(tender.getTenderType()) == "Card") paymentCardInd = "15";
           
//From webmethods
//INSERT INTO SA_BASKET_TENDER_CREDIT_CARD(TXN_TENDER_CREDIT_CARD_KEY,TXN_KEY,TXN_TENDER_KEY,TRADING_DATE,STORE,LOAD_DATE_TIME,
// PAYMENT_CARD_TYPE_IND,ACCOUNT_NO,EXPIRY_DATE,CASHBACK,ISSUE_NO,OLA_AUTH_CODE,PAYMENT_CARD_REFERRAL,PAYMENT_CARD_DECLINE_IND,
// START_DATE,WAIT_TIME,TOTAL_NETWORK_TIME,POS_TERM_TYPE,PAYMENT_CARD_ENTRY_IND,OLA_IND,CNP,MERCHANT_NUMBER,SAVEBACK,PAYMENT_CARD_SCHEME,PA_RESULT)
// VALUES (TXN_CREDIT_CARD_KEY_SEQ.NEXTVAL,TXN_KEY_SEQ.CURRVAL,TXN_TENDER_KEY_SEQ.CURRVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)


        String insertSQL = "INSERT INTO RSAPPF7_OWNER.SA_BASKET_TENDER_CREDIT_CARD(TXN_TENDER_CREDIT_CARD_KEY,TXN_KEY,TXN_TENDER_KEY, TRADING_DATE, STORE, LOAD_DATE_TIME,  PAYMENT_CARD_TYPE_IND   , " +
                " ACCOUNT_NO, EXPIRY_DATE,  CASHBACK, ISSUE_NO,OLA_AUTH_CODE , PAYMENT_CARD_REFERRAL,PAYMENT_CARD_DECLINE_IND," +
                " START_DATE, WAIT_TIME, TOTAL_NETWORK_TIME, POS_TERM_TYPE,  PAYMENT_CARD_ENTRY_IND, OLA_IND, CNP, MERCHANT_NUMBER," +
                "SAVEBACK ,PAYMENT_CARD_SCHEME, PA_RESULT) " +
                "VALUES(RSAPPF7_OWNER.TXN_TENDER_CREDIT_CARD_KEY_SEQ.NEXTVAL,TXN_KEY_SEQ.CURRVAL,RSAPPF7_OWNER.TXN_TENDER_KEY_SEQ.CURRVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
        PreparedStatement psInsert = conn.prepareStatement(insertSQL);





        psInsert.setTimestamp(1, (Timestamp) payload.getTradingDayDate());
        psInsert.setLong(2, STOREID);
        psInsert.setDate(3, (Date) payload.getStartTransDateTime());
        psInsert.setString(4, paymentCardInd);
        psInsert.setString(5, "0");
        psInsert.setString(6, "0");
        psInsert.setDouble(7, 0.00);
        psInsert.setString(8, "N");
        psInsert.setString(9, "N");
        psInsert.setString(10, "X");
        psInsert.setString(11, "0000");
        psInsert.setLong(12, 0);
        psInsert.setLong(13, 0);
        psInsert.setLong(14, 0);
        psInsert.setLong(15, 3);
        psInsert.setString(16, "X");
        psInsert.setString(17, "X");
        psInsert.setString(18, "Y");
        psInsert.setString(19, "123456789");
        psInsert.setDouble(20, 0.0000);
        psInsert.setLong(21, 0);
        psInsert.setLong(22, 0);

        System.out.println("insert sql  " + insertSQL);

        try {
            psInsert.execute();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
