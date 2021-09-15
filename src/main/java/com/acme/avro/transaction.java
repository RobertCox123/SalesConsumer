/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.acme.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class transaction extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3229700610627002004L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"transaction\",\"namespace\":\"com.acme.avro\",\"fields\":[{\"name\":\"lineItems\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"lineItems_record\",\"fields\":[{\"name\":\"lineTransType\",\"type\":\"string\"},{\"name\":\"lineType\",\"type\":\"string\"},{\"name\":\"lineSeq\",\"type\":\"int\"},{\"name\":\"posItemId\",\"type\":\"string\"},{\"name\":\"eanNumber\",\"type\":\"string\"},{\"name\":\"description\",\"type\":\"string\"},{\"name\":\"jsItemFlag\",\"type\":\"string\"},{\"name\":\"unitPrice\",\"type\":\"string\"},{\"name\":\"quantity\",\"type\":\"string\"},{\"name\":\"uom\",\"type\":\"string\"},{\"name\":\"extendedValue\",\"type\":\"string\"},{\"name\":\"returnCode\",\"type\":\"string\"},{\"name\":\"priceModifier\",\"type\":{\"type\":\"record\",\"name\":\"priceModifier\",\"fields\":[{\"name\":\"promotionCode\",\"type\":\"string\"},{\"name\":\"partnerCode\",\"type\":\"string\"},{\"name\":\"promotionDiscount\",\"type\":\"string\"},{\"name\":\"staffDiscount\",\"type\":\"string\"},{\"name\":\"newPrice\",\"type\":\"string\"},{\"name\":\"promotionType\",\"type\":\"string\"},{\"name\":\"promotionDescription\",\"type\":\"string\"}]}},{\"name\":\"source\",\"type\":\"string\"},{\"name\":\"consumableGroup\",\"type\":\"string\"},{\"name\":\"hierarchy\",\"type\":{\"type\":\"record\",\"name\":\"hierarchy\",\"fields\":[{\"name\":\"groupId\",\"type\":\"string\"},{\"name\":\"subcategoryId\",\"type\":\"string\"},{\"name\":\"categoryId\",\"type\":\"string\"}]}},{\"name\":\"scanData\",\"type\":\"string\"},{\"name\":\"startDateTime\",\"type\":\"string\"},{\"name\":\"endDateTime\",\"type\":\"string\"}]}}},{\"name\":\"tenderTypes\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"tenderTypes_record\",\"fields\":[{\"name\":\"tenderType\",\"type\":\"string\"},{\"name\":\"lineSeq\",\"type\":\"int\"},{\"name\":\"amount\",\"type\":\"string\"},{\"name\":\"startDateTime\",\"type\":\"string\"},{\"name\":\"endDateTime\",\"type\":\"string\"}]}}},{\"name\":\"promotionRedemption\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"promotionRedemption_record\",\"fields\":[{\"name\":\"promotionCode\",\"type\":\"string\"},{\"name\":\"partnerCode\",\"type\":\"string\"},{\"name\":\"redemptionQuantity\",\"type\":\"int\"}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<transaction> ENCODER =
      new BinaryMessageEncoder<transaction>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<transaction> DECODER =
      new BinaryMessageDecoder<transaction>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<transaction> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<transaction> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<transaction>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this transaction to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a transaction from a ByteBuffer. */
  public static transaction fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.util.List<com.acme.avro.lineItems_record> lineItems;
  @Deprecated public java.util.List<com.acme.avro.tenderTypes_record> tenderTypes;
  @Deprecated public java.util.List<com.acme.avro.promotionRedemption_record> promotionRedemption;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public transaction() {}

  /**
   * All-args constructor.
   * @param lineItems The new value for lineItems
   * @param tenderTypes The new value for tenderTypes
   * @param promotionRedemption The new value for promotionRedemption
   */
  public transaction(java.util.List<com.acme.avro.lineItems_record> lineItems, java.util.List<com.acme.avro.tenderTypes_record> tenderTypes, java.util.List<com.acme.avro.promotionRedemption_record> promotionRedemption) {
    this.lineItems = lineItems;
    this.tenderTypes = tenderTypes;
    this.promotionRedemption = promotionRedemption;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return lineItems;
    case 1: return tenderTypes;
    case 2: return promotionRedemption;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: lineItems = (java.util.List<com.acme.avro.lineItems_record>)value$; break;
    case 1: tenderTypes = (java.util.List<com.acme.avro.tenderTypes_record>)value$; break;
    case 2: promotionRedemption = (java.util.List<com.acme.avro.promotionRedemption_record>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'lineItems' field.
   * @return The value of the 'lineItems' field.
   */
  public java.util.List<com.acme.avro.lineItems_record> getLineItems() {
    return lineItems;
  }

  /**
   * Sets the value of the 'lineItems' field.
   * @param value the value to set.
   */
  public void setLineItems(java.util.List<com.acme.avro.lineItems_record> value) {
    this.lineItems = value;
  }

  /**
   * Gets the value of the 'tenderTypes' field.
   * @return The value of the 'tenderTypes' field.
   */
  public java.util.List<com.acme.avro.tenderTypes_record> getTenderTypes() {
    return tenderTypes;
  }

  /**
   * Sets the value of the 'tenderTypes' field.
   * @param value the value to set.
   */
  public void setTenderTypes(java.util.List<com.acme.avro.tenderTypes_record> value) {
    this.tenderTypes = value;
  }

  /**
   * Gets the value of the 'promotionRedemption' field.
   * @return The value of the 'promotionRedemption' field.
   */
  public java.util.List<com.acme.avro.promotionRedemption_record> getPromotionRedemption() {
    return promotionRedemption;
  }

  /**
   * Sets the value of the 'promotionRedemption' field.
   * @param value the value to set.
   */
  public void setPromotionRedemption(java.util.List<com.acme.avro.promotionRedemption_record> value) {
    this.promotionRedemption = value;
  }

  /**
   * Creates a new transaction RecordBuilder.
   * @return A new transaction RecordBuilder
   */
  public static com.acme.avro.transaction.Builder newBuilder() {
    return new com.acme.avro.transaction.Builder();
  }

  /**
   * Creates a new transaction RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new transaction RecordBuilder
   */
  public static com.acme.avro.transaction.Builder newBuilder(com.acme.avro.transaction.Builder other) {
    return new com.acme.avro.transaction.Builder(other);
  }

  /**
   * Creates a new transaction RecordBuilder by copying an existing transaction instance.
   * @param other The existing instance to copy.
   * @return A new transaction RecordBuilder
   */
  public static com.acme.avro.transaction.Builder newBuilder(com.acme.avro.transaction other) {
    return new com.acme.avro.transaction.Builder(other);
  }

  /**
   * RecordBuilder for transaction instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<transaction>
    implements org.apache.avro.data.RecordBuilder<transaction> {

    private java.util.List<com.acme.avro.lineItems_record> lineItems;
    private java.util.List<com.acme.avro.tenderTypes_record> tenderTypes;
    private java.util.List<com.acme.avro.promotionRedemption_record> promotionRedemption;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.acme.avro.transaction.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.lineItems)) {
        this.lineItems = data().deepCopy(fields()[0].schema(), other.lineItems);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tenderTypes)) {
        this.tenderTypes = data().deepCopy(fields()[1].schema(), other.tenderTypes);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.promotionRedemption)) {
        this.promotionRedemption = data().deepCopy(fields()[2].schema(), other.promotionRedemption);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing transaction instance
     * @param other The existing instance to copy.
     */
    private Builder(com.acme.avro.transaction other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.lineItems)) {
        this.lineItems = data().deepCopy(fields()[0].schema(), other.lineItems);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tenderTypes)) {
        this.tenderTypes = data().deepCopy(fields()[1].schema(), other.tenderTypes);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.promotionRedemption)) {
        this.promotionRedemption = data().deepCopy(fields()[2].schema(), other.promotionRedemption);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'lineItems' field.
      * @return The value.
      */
    public java.util.List<com.acme.avro.lineItems_record> getLineItems() {
      return lineItems;
    }

    /**
      * Sets the value of the 'lineItems' field.
      * @param value The value of 'lineItems'.
      * @return This builder.
      */
    public com.acme.avro.transaction.Builder setLineItems(java.util.List<com.acme.avro.lineItems_record> value) {
      validate(fields()[0], value);
      this.lineItems = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'lineItems' field has been set.
      * @return True if the 'lineItems' field has been set, false otherwise.
      */
    public boolean hasLineItems() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'lineItems' field.
      * @return This builder.
      */
    public com.acme.avro.transaction.Builder clearLineItems() {
      lineItems = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'tenderTypes' field.
      * @return The value.
      */
    public java.util.List<com.acme.avro.tenderTypes_record> getTenderTypes() {
      return tenderTypes;
    }

    /**
      * Sets the value of the 'tenderTypes' field.
      * @param value The value of 'tenderTypes'.
      * @return This builder.
      */
    public com.acme.avro.transaction.Builder setTenderTypes(java.util.List<com.acme.avro.tenderTypes_record> value) {
      validate(fields()[1], value);
      this.tenderTypes = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'tenderTypes' field has been set.
      * @return True if the 'tenderTypes' field has been set, false otherwise.
      */
    public boolean hasTenderTypes() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'tenderTypes' field.
      * @return This builder.
      */
    public com.acme.avro.transaction.Builder clearTenderTypes() {
      tenderTypes = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'promotionRedemption' field.
      * @return The value.
      */
    public java.util.List<com.acme.avro.promotionRedemption_record> getPromotionRedemption() {
      return promotionRedemption;
    }

    /**
      * Sets the value of the 'promotionRedemption' field.
      * @param value The value of 'promotionRedemption'.
      * @return This builder.
      */
    public com.acme.avro.transaction.Builder setPromotionRedemption(java.util.List<com.acme.avro.promotionRedemption_record> value) {
      validate(fields()[2], value);
      this.promotionRedemption = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'promotionRedemption' field has been set.
      * @return True if the 'promotionRedemption' field has been set, false otherwise.
      */
    public boolean hasPromotionRedemption() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'promotionRedemption' field.
      * @return This builder.
      */
    public com.acme.avro.transaction.Builder clearPromotionRedemption() {
      promotionRedemption = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public transaction build() {
      try {
        transaction record = new transaction();
        record.lineItems = fieldSetFlags()[0] ? this.lineItems : (java.util.List<com.acme.avro.lineItems_record>) defaultValue(fields()[0]);
        record.tenderTypes = fieldSetFlags()[1] ? this.tenderTypes : (java.util.List<com.acme.avro.tenderTypes_record>) defaultValue(fields()[1]);
        record.promotionRedemption = fieldSetFlags()[2] ? this.promotionRedemption : (java.util.List<com.acme.avro.promotionRedemption_record>) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<transaction>
    WRITER$ = (org.apache.avro.io.DatumWriter<transaction>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<transaction>
    READER$ = (org.apache.avro.io.DatumReader<transaction>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
