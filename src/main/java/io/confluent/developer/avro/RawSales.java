/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.confluent.developer.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class RawSales extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5066340504978037813L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"RawSales\",\"namespace\":\"io.confluent.developer.avro\",\"fields\":[{\"name\":\"storeId\",\"type\":\"long\"},{\"name\":\"tillId\",\"type\":\"string\"},{\"name\":\"basketKey\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<RawSales> ENCODER =
      new BinaryMessageEncoder<RawSales>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<RawSales> DECODER =
      new BinaryMessageDecoder<RawSales>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<RawSales> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<RawSales> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<RawSales>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this RawSales to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a RawSales from a ByteBuffer. */
  public static RawSales fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public static long storeId;
  @Deprecated public java.lang.CharSequence tillId;
  @Deprecated public java.lang.CharSequence basketKey;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public RawSales() {}

  /**
   * All-args constructor.
   * @param storeId The new value for storeId
   * @param tillId The new value for tillId
   * @param basketKey The new value for basketKey
   */
  public RawSales(java.lang.Long storeId, java.lang.CharSequence tillId, java.lang.CharSequence basketKey) {
    this.storeId = storeId;
    this.tillId = tillId;
    this.basketKey = basketKey;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return storeId;
    case 1: return tillId;
    case 2: return basketKey;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: storeId = (java.lang.Long)value$; break;
    case 1: tillId = (java.lang.CharSequence)value$; break;
    case 2: basketKey = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'storeId' field.
   * @return The value of the 'storeId' field.
   */
  public java.lang.Long getStoreId() {
    return storeId;
  }

  /**
   * Sets the value of the 'storeId' field.
   * @param value the value to set.
   */
  public void setStoreId(java.lang.Long value) {
    this.storeId = value;
  }

  /**
   * Gets the value of the 'tillId' field.
   * @return The value of the 'tillId' field.
   */
  public java.lang.CharSequence getTillId() {
    return tillId;
  }

  /**
   * Sets the value of the 'tillId' field.
   * @param value the value to set.
   */
  public void setTillId(java.lang.CharSequence value) {
    this.tillId = value;
  }

  /**
   * Gets the value of the 'basketKey' field.
   * @return The value of the 'basketKey' field.
   */
  public java.lang.CharSequence getBasketKey() {
    return basketKey;
  }

  /**
   * Sets the value of the 'basketKey' field.
   * @param value the value to set.
   */
  public void setBasketKey(java.lang.CharSequence value) {
    this.basketKey = value;
  }

  /**
   * Creates a new RawSales RecordBuilder.
   * @return A new RawSales RecordBuilder
   */
  public static io.confluent.developer.avro.RawSales.Builder newBuilder() {
    return new io.confluent.developer.avro.RawSales.Builder();
  }

  /**
   * Creates a new RawSales RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new RawSales RecordBuilder
   */
  public static io.confluent.developer.avro.RawSales.Builder newBuilder(io.confluent.developer.avro.RawSales.Builder other) {
    return new io.confluent.developer.avro.RawSales.Builder(other);
  }

  /**
   * Creates a new RawSales RecordBuilder by copying an existing RawSales instance.
   * @param other The existing instance to copy.
   * @return A new RawSales RecordBuilder
   */
  public static io.confluent.developer.avro.RawSales.Builder newBuilder(io.confluent.developer.avro.RawSales other) {
    return new io.confluent.developer.avro.RawSales.Builder(other);
  }

  /**
   * RecordBuilder for RawSales instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<RawSales>
    implements org.apache.avro.data.RecordBuilder<RawSales> {

    private long storeId;
    private java.lang.CharSequence tillId;
    private java.lang.CharSequence basketKey;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.confluent.developer.avro.RawSales.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.storeId)) {
        this.storeId = data().deepCopy(fields()[0].schema(), other.storeId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tillId)) {
        this.tillId = data().deepCopy(fields()[1].schema(), other.tillId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.basketKey)) {
        this.basketKey = data().deepCopy(fields()[2].schema(), other.basketKey);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing RawSales instance
     * @param other The existing instance to copy.
     */
    private Builder(io.confluent.developer.avro.RawSales other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.storeId)) {
        this.storeId = data().deepCopy(fields()[0].schema(), other.storeId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tillId)) {
        this.tillId = data().deepCopy(fields()[1].schema(), other.tillId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.basketKey)) {
        this.basketKey = data().deepCopy(fields()[2].schema(), other.basketKey);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'storeId' field.
      * @return The value.
      */
    public java.lang.Long getStoreId() {
      return storeId;
    }

    /**
      * Sets the value of the 'storeId' field.
      * @param value The value of 'storeId'.
      * @return This builder.
      */
    public io.confluent.developer.avro.RawSales.Builder setStoreId(long value) {
      validate(fields()[0], value);
      this.storeId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'storeId' field has been set.
      * @return True if the 'storeId' field has been set, false otherwise.
      */
    public boolean hasStoreId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'storeId' field.
      * @return This builder.
      */
    public io.confluent.developer.avro.RawSales.Builder clearStoreId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'tillId' field.
      * @return The value.
      */
    public java.lang.CharSequence getTillId() {
      return tillId;
    }

    /**
      * Sets the value of the 'tillId' field.
      * @param value The value of 'tillId'.
      * @return This builder.
      */
    public io.confluent.developer.avro.RawSales.Builder setTillId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.tillId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'tillId' field has been set.
      * @return True if the 'tillId' field has been set, false otherwise.
      */
    public boolean hasTillId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'tillId' field.
      * @return This builder.
      */
    public io.confluent.developer.avro.RawSales.Builder clearTillId() {
      tillId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'basketKey' field.
      * @return The value.
      */
    public java.lang.CharSequence getBasketKey() {
      return basketKey;
    }

    /**
      * Sets the value of the 'basketKey' field.
      * @param value The value of 'basketKey'.
      * @return This builder.
      */
    public io.confluent.developer.avro.RawSales.Builder setBasketKey(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.basketKey = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'basketKey' field has been set.
      * @return True if the 'basketKey' field has been set, false otherwise.
      */
    public boolean hasBasketKey() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'basketKey' field.
      * @return This builder.
      */
    public io.confluent.developer.avro.RawSales.Builder clearBasketKey() {
      basketKey = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RawSales build() {
      try {
        RawSales record = new RawSales();
        record.storeId = fieldSetFlags()[0] ? this.storeId : (java.lang.Long) defaultValue(fields()[0]);
        record.tillId = fieldSetFlags()[1] ? this.tillId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.basketKey = fieldSetFlags()[2] ? this.basketKey : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<RawSales>
    WRITER$ = (org.apache.avro.io.DatumWriter<RawSales>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<RawSales>
    READER$ = (org.apache.avro.io.DatumReader<RawSales>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
