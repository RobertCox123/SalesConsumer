package com.sainsburys.transformers.SalesConsumer.adapters;

import com.acme.avro.hierarchy;
import com.acme.avro.payLoad;
import com.acme.avro.priceModifier;
import com.acme.avro.promotionRedemption_record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class Insert_SA_PROM_HEAD {
    private static final Logger LOGGER = LoggerFactory.getLogger(Insert_SA_BASKET_PROM_ITEM.class);

    // private boolean commitOffsets;

    @Autowired
    //public JdbcTemplate jdbcTemplate;

    private promotionRedemption_record promhead;
    private payLoad payload;
    private priceModifier pricemodifier;
    private hierarchy Hierarchy;

    public Insert_SA_PROM_HEAD(Connection conn, Long STOREID) throws SQLException {


        String insertSQL = "INSERT INTO  RSAPPF7_OWNER.SA_PROM_HEAD(TXN_PROM_KEY, TXN_KEY, TRADING_DATE, STORE, LOAD_DATE_TIME, PROMOTION_ID,  PROMOTION_TYPE,  " +
                "PROMOTION_QTY, CASH_POINTS_IND,VALID_PROMOTION_IND, PROM_CLASS,  SUBST_PROM_CLASS  )" +
                " VALUES (RSAPPF7_OWNER.TXN_PROM_KEY_SEQ.NEXTVAL, RSAPPF7_OWNER.TXN_KEY_SEQ.CURRVAL,?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement psInsert = conn.prepareStatement(insertSQL);


        // psInsert.setLong(1,9999);
        psInsert.setTimestamp(5, (Timestamp) payload.getTradingDayDate());
        psInsert.setLong(2, STOREID);
        psInsert.setDate(4, (Date) payload.getStartTransDateTime());
        psInsert.setInt( 4, Integer.parseInt(String.valueOf(promhead.getPromotionCode())));
        psInsert.setInt(5, Integer.parseInt(String.valueOf(pricemodifier.getPromotionType())));
        psInsert.setInt(5, Integer.parseInt(String.valueOf(promhead.getRedemptionQuantity())));
        psInsert.setString(4, "C");
        psInsert.setInt(5, Integer.parseInt(String.valueOf(pricemodifier.getPromotionType())));
        psInsert.setString(4, String.valueOf(Hierarchy.getCategoryId()));
        psInsert.setInt(4, 0);


        System.out.println("insert sql  " + insertSQL);

        try {
            psInsert.execute();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
