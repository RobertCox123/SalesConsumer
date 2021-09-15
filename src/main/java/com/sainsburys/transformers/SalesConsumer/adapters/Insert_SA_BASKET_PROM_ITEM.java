package com.sainsburys.transformers.SalesConsumer.adapters;

import com.acme.avro.hierarchy;
import com.acme.avro.lineItems_record;
import com.acme.avro.priceModifier;
import com.acme.avro.promotionRedemption_record;
//import io.confluent.developer.avro.RawSales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class Insert_SA_BASKET_PROM_ITEM {
    private static final Logger LOGGER = LoggerFactory.getLogger(Insert_SA_BASKET_PROM_ITEM.class);

    // private boolean commitOffsets;

    @Autowired
    //public JdbcTemplate jdbcTemplate;
    //private RawSales rawSales ;
    private promotionRedemption_record promotion_record;
    private lineItems_record basketitems;
    private priceModifier pricemodifier;
    private hierarchy Hierarchy;


    public Insert_SA_BASKET_PROM_ITEM(Connection conn, Long STOREID) throws SQLException {


        //Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
        //Connection conn = DataSourceUtils.getConnection (jdbcTemplate.getDataSource ());
//"INSERT INTO  RSAPPF7_OWNER.SA_BASKET_PROM_ITEM(TXN_PROM_ITEM_KEY, TXN_KEY, TXN_PROM_KEY, TRADING_DATE, STORE, LOAD_DATE_TIME, PROMOTION_ID, SKU, UPC_EAN, APPORTIONED_VAL, PROM_ITEM_COUNT, SUBST_UPC_EAN, SUBST_CLASS, SALES_GROUP, CLASS) VALUES (RSAPPF7_OWNER.TXN_PROM_ITEM_KEY_SEQ.NEXTVAL, RSAPPF7_OWNER.TXN_KEY_SEQ.CURRVAL, RSAPPF7_OWNER.TXN_PROM_KEY_SEQ.CURRVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
        String catagoryId = "03_09_86";

        if (String.valueOf(basketitems.getJsItemFlag()) =="Y") {
            if (String.valueOf(basketitems.getSource()) =="v10") catagoryId = "3_10" + Hierarchy.getCategoryId();
            {
                LOGGER.info("Source" + basketitems.getSource());
            }
            if (String.valueOf(basketitems.getSource()) =="v9") catagoryId = "3_9" + Hierarchy.getCategoryId();
            {
                LOGGER.info("Source" + basketitems.getSource());
            }
        }else catagoryId = "3_09_33";

        String insertSQL = "INSERT INTO  RSAPPF7_OWNER.SA_BASKET_PROM_ITEM(TXN_PROM_ITEM_KEY, TXN_KEY, TXN_PROM_KEY, TRADING_DATE, STORE, LOAD_DATE_TIME, PROMOTION_ID, SKU, UPC_EAN, APPORTIONED_VAL, PROM_ITEM_COUNT, SUBST_UPC_EAN, SUBST_CLASS, SALES_GROUP, CLASS)" +
                " VALUES (RSAPPF7_OWNER.TXN_PROM_ITEM_KEY_SEQ.NEXTVAL, RSAPPF7_OWNER.TXN_KEY_SEQ.CURRVAL, RSAPPF7_OWNER.TXN_PROM_KEY_SEQ.CURRVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement psInsert = conn.prepareStatement(insertSQL);





        // psInsert.setLong(1,9999);
        psInsert.setDate(1, Date.valueOf("2021-07-06"));
        psInsert.setLong(2, STOREID);
        psInsert.setDate(3, Date.valueOf("2021-07-14"));
        psInsert.setString(4, String.valueOf(pricemodifier.getPromotionCode()));
        psInsert.setString(5, String.valueOf(basketitems.getPosItemId()));
        psInsert.setString(6, String.valueOf(basketitems.getEanNumber()));
        psInsert.setString(7, String.valueOf(pricemodifier.getPromotionDiscount()));
        psInsert.setString(8, String.valueOf(promotion_record.getRedemptionQuantity()));
        psInsert.setString(9, " ");
        psInsert.setLong(10, 0);
        psInsert.setString(11, String.valueOf(basketitems.getConsumableGroup()));
        // need characters following prefix sale-group may need to [ass into procedure
        psInsert.setString(12,catagoryId);


        System.out.println("insert sql  " + insertSQL);

        try {
            psInsert.execute();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}

