package com.sainsburys.transformers.SalesConsumer.Adapters;

import com.acme.avro.STSSales;
import com.acme.avro.lineItems_record;
import io.confluent.developer.avro.RawSales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class Insert_SA_BASKET_ITEM {

    private static final Logger LOGGER = LoggerFactory.getLogger(Insert_SA_BASKET_HEAD.class);

    // private boolean commitOffsets;

    @Autowired
    //public JdbcTemplate jdbcTemplate;
    private STSSales stsSales ;
    private lineItems_record basketitems;


    public Insert_SA_BASKET_ITEM(Connection conn, Long STOREID) throws SQLException {


        //Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
        //Connection conn = DataSourceUtils.getConnection (jdbcTemplate.getDataSource ());


        String insertSQL = "INSERT INTO RSAPPF7_OWNER.SA_BASKET_ITEM " +
                "(TXN_ITEM_KEY,TXN_KEY,TRADING_DATE,STORE,LOAD_DATE_TIME,SALES_GROUP,LONG_SHORT_SALE_IND,CLASS_GROUP,SKU,UPC_EAN,CANCEL_ITEM_IND,SUBTRACT_ITEM_IND,UNKNOWN_ITEM_IND,COMP_ITEM_IND,LINKED_ITEM_IND,GROUP_SALE_IND,DEPARTMENT_MODE,EXTEND_PRICE,QUANTITY,UNIT_CONVERSION_QTY,UNIT_CONVERSION_IND,UNIT_PRICE,AT_FOR_QTY,PRICE_FROM_PLU,KEYED_PRICE,SYS_REDUCTION_ID,REDUCTION_IND,REFUND_ITEM_IND,REFUND_REASON_CODE,ITEM_ENTRY_IND,WEIGHT_VOLUME,SUBST_UPC_EAN,SUBST_CLASS_GROUP,SUBST_PRICE_FROM_PLU," +

        "DRIVE_OFF_IND,PENNY_PER_LITRE_DISCOUNT,FUEL_ITEM_IND,PUMP_TEST_IND,GRADE_PRICE,NORMAL_ITEM_VALUE) VALUES (TXN_ITEM_KEY_SEQ.NEXTVAL,TXN_KEY_SEQ.CURRVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement psInsert = conn.prepareStatement(insertSQL);





        // psInsert.setLong(1,9999);
        psInsert.setDate(1, Date.valueOf("2021-07-06"));
        psInsert.setLong(2, STOREID);
        psInsert.setDate(3, Date.valueOf("2021-07-14"));
        psInsert.setString(4, "N");
        psInsert.setString(4, "N");
        psInsert.setLong(2, STOREID);
        psInsert.setString(2, String.valueOf(basketitems.getPosItemId()));
        psInsert.setString(2, String.valueOf(basketitems.getEanNumber()));
        psInsert.setString(4, "N");
        psInsert.setString(4, "N");
        psInsert.setString(4, "N");
        psInsert.setString(4, "N");
        psInsert.setString(4, "N");
        psInsert.setString(4, "N");
        psInsert.setString(4, "0");
        psInsert.setDouble(4, Double.parseDouble((String) basketitems.getExtendedValue())); // avro generated code changed to return double
        psInsert.setLong(4, Integer.parseInt(String.valueOf(basketitems.getQuantity()))); // avro Char sequence
        psInsert.setDouble(4, Double.parseDouble((String) basketitems.getUnitPrice()));
        psInsert.setInt(2, 0);
        psInsert.setDouble(4, Double.parseDouble((String) basketitems.getUnitPrice()));
        psInsert.setString(4, "N");
        psInsert.setString(4, String.valueOf(basketitems.getScanData()));
        psInsert.setString(4, "N");
        psInsert.setString(4, String.valueOf(basketitems.getReturnCode()));
        psInsert.setString(4, String.valueOf(basketitems.getScanData()));









        psInsert.setTimestamp(4, Timestamp.valueOf("2021-07-14 11:00:00"));

        System.out.println("insert sql  " + insertSQL);

        try {
            psInsert.execute();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
