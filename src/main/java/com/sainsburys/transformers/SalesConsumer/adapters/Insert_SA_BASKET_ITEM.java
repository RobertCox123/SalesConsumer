package com.sainsburys.transformers.SalesConsumer.adapters;

import com.acme.avro.STSSales;
import com.acme.avro.lineItems_record;
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


    public Insert_SA_BASKET_ITEM(Connection conn, Long storeId, Date tradingDayDate, Timestamp startTransDateTime, String eanNumber, String posItemId, Double extendedValue, Integer quantity, Double unitPrice, String scanData, String returnCode, String salesGroup, Long group, String fuelItem) throws SQLException {


        //Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
        //Connection conn = DataSourceUtils.getConnection (jdbcTemplate.getDataSource ());


        String insertSQL = "INSERT INTO RSAPPF7_OWNER.SA_BASKET_ITEM " +
                "(TXN_ITEM_KEY,TXN_KEY,TRADING_DATE,STORE,LOAD_DATE_TIME,SALES_GROUP,LONG_SHORT_SALE_IND,CLASS_GROUP,SKU,UPC_EAN,CANCEL_ITEM_IND,SUBTRACT_ITEM_IND,UNKNOWN_ITEM_IND,COMP_ITEM_IND,LINKED_ITEM_IND,GROUP_SALE_IND,DEPARTMENT_MODE,EXTEND_PRICE,QUANTITY,UNIT_CONVERSION_QTY,UNIT_CONVERSION_IND,UNIT_PRICE,AT_FOR_QTY,PRICE_FROM_PLU,KEYED_PRICE,SYS_REDUCTION_ID,REDUCTION_IND,REFUND_ITEM_IND,REFUND_REASON_CODE,ITEM_ENTRY_IND,WEIGHT_VOLUME,SUBST_UPC_EAN,SUBST_CLASS_GROUP,SUBST_PRICE_FROM_PLU," +

        "DRIVE_OFF_IND,PENNY_PER_LITRE_DISCOUNT,FUEL_ITEM_IND,PUMP_TEST_IND,GRADE_PRICE,NORMAL_ITEM_VALUE) VALUES (TXN_ITEM_KEY_SEQ.NEXTVAL,TXN_KEY_SEQ.CURRVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement psInsert = conn.prepareStatement(insertSQL);





        // psInsert.setLong(1,9999);
        psInsert.setDate(1, tradingDayDate);
        psInsert.setLong(2, storeId);
        psInsert.setTimestamp(3, startTransDateTime);//loaddate
        psInsert.setString(4, salesGroup);
        psInsert.setString(5, "S");
        psInsert.setLong(6, group);
        psInsert.setString(7, posItemId);
        psInsert.setString(8, eanNumber);
        psInsert.setString(9, "N");
        psInsert.setString(10, "N");
        psInsert.setString(11, "N");
        psInsert.setString(12, "X");
        psInsert.setString(13, "N");
        psInsert.setString(14, "X");
        psInsert.setString(15, "X");
        psInsert.setDouble(16, extendedValue);
        psInsert.setLong(17, quantity);
        psInsert.setDouble(18, unitPrice);
        psInsert.setInt(19, 0);
        psInsert.setDouble(20, unitPrice);
        psInsert.setString(20, "N");
        psInsert.setString(21, scanData);
        psInsert.setString(22, "N");
        psInsert.setString(23,returnCode);
        psInsert.setString(24, "K");
        psInsert.setDouble(25, quantity);
        psInsert.setString(26, "0000000000000");
        psInsert.setDouble(27,  0000);
        psInsert.setDouble(28,  0.0000);
        psInsert.setString(29, "N");
        psInsert.setDouble(30, extendedValue); // should be discount amount but missing
        psInsert.setString(29, fuelItem);
        psInsert.setString(29, "N");
        psInsert.setDouble(20, unitPrice * 100);
        psInsert.setDouble(20, unitPrice);



















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
