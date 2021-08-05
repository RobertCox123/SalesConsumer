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
public class hierarchy extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8027171176349934575L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"hierarchy\",\"namespace\":\"com.acme.avro\",\"fields\":[{\"name\":\"groupId\",\"type\":\"string\"},{\"name\":\"subcategoryId\",\"type\":\"string\"},{\"name\":\"categoryId\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<hierarchy> ENCODER =
      new BinaryMessageEncoder<hierarchy>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<hierarchy> DECODER =
      new BinaryMessageDecoder<hierarchy>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<hierarchy> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<hierarchy> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<hierarchy>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this hierarchy to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a hierarchy from a ByteBuffer. */
  public static hierarchy fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence groupId;
  @Deprecated public java.lang.CharSequence subcategoryId;
  @Deprecated public java.lang.CharSequence categoryId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public hierarchy() {}

  /**
   * All-args constructor.
   * @param groupId The new value for groupId
   * @param subcategoryId The new value for subcategoryId
   * @param categoryId The new value for categoryId
   */
  public hierarchy(java.lang.CharSequence groupId, java.lang.CharSequence subcategoryId, java.lang.CharSequence categoryId) {
    this.groupId = groupId;
    this.subcategoryId = subcategoryId;
    this.categoryId = categoryId;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return groupId;
    case 1: return subcategoryId;
    case 2: return categoryId;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: groupId = (java.lang.CharSequence)value$; break;
    case 1: subcategoryId = (java.lang.CharSequence)value$; break;
    case 2: categoryId = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'groupId' field.
   * @return The value of the 'groupId' field.
   */
  public java.lang.CharSequence getGroupId() {
    return groupId;
  }

  /**
   * Sets the value of the 'groupId' field.
   * @param value the value to set.
   */
  public void setGroupId(java.lang.CharSequence value) {
    this.groupId = value;
  }

  /**
   * Gets the value of the 'subcategoryId' field.
   * @return The value of the 'subcategoryId' field.
   */
  public java.lang.CharSequence getSubcategoryId() {
    return subcategoryId;
  }

  /**
   * Sets the value of the 'subcategoryId' field.
   * @param value the value to set.
   */
  public void setSubcategoryId(java.lang.CharSequence value) {
    this.subcategoryId = value;
  }

  /**
   * Gets the value of the 'categoryId' field.
   * @return The value of the 'categoryId' field.
   */
  public java.lang.CharSequence getCategoryId() {
    return categoryId;
  }

  /**
   * Sets the value of the 'categoryId' field.
   * @param value the value to set.
   */
  public void setCategoryId(java.lang.CharSequence value) {
    this.categoryId = value;
  }

  /**
   * Creates a new hierarchy RecordBuilder.
   * @return A new hierarchy RecordBuilder
   */
  public static com.acme.avro.hierarchy.Builder newBuilder() {
    return new com.acme.avro.hierarchy.Builder();
  }

  /**
   * Creates a new hierarchy RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new hierarchy RecordBuilder
   */
  public static com.acme.avro.hierarchy.Builder newBuilder(com.acme.avro.hierarchy.Builder other) {
    return new com.acme.avro.hierarchy.Builder(other);
  }

  /**
   * Creates a new hierarchy RecordBuilder by copying an existing hierarchy instance.
   * @param other The existing instance to copy.
   * @return A new hierarchy RecordBuilder
   */
  public static com.acme.avro.hierarchy.Builder newBuilder(com.acme.avro.hierarchy other) {
    return new com.acme.avro.hierarchy.Builder(other);
  }

  /**
   * RecordBuilder for hierarchy instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<hierarchy>
    implements org.apache.avro.data.RecordBuilder<hierarchy> {

    private java.lang.CharSequence groupId;
    private java.lang.CharSequence subcategoryId;
    private java.lang.CharSequence categoryId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.acme.avro.hierarchy.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.groupId)) {
        this.groupId = data().deepCopy(fields()[0].schema(), other.groupId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.subcategoryId)) {
        this.subcategoryId = data().deepCopy(fields()[1].schema(), other.subcategoryId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.categoryId)) {
        this.categoryId = data().deepCopy(fields()[2].schema(), other.categoryId);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing hierarchy instance
     * @param other The existing instance to copy.
     */
    private Builder(com.acme.avro.hierarchy other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.groupId)) {
        this.groupId = data().deepCopy(fields()[0].schema(), other.groupId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.subcategoryId)) {
        this.subcategoryId = data().deepCopy(fields()[1].schema(), other.subcategoryId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.categoryId)) {
        this.categoryId = data().deepCopy(fields()[2].schema(), other.categoryId);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'groupId' field.
      * @return The value.
      */
    public java.lang.CharSequence getGroupId() {
      return groupId;
    }

    /**
      * Sets the value of the 'groupId' field.
      * @param value The value of 'groupId'.
      * @return This builder.
      */
    public com.acme.avro.hierarchy.Builder setGroupId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.groupId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'groupId' field has been set.
      * @return True if the 'groupId' field has been set, false otherwise.
      */
    public boolean hasGroupId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'groupId' field.
      * @return This builder.
      */
    public com.acme.avro.hierarchy.Builder clearGroupId() {
      groupId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'subcategoryId' field.
      * @return The value.
      */
    public java.lang.CharSequence getSubcategoryId() {
      return subcategoryId;
    }

    /**
      * Sets the value of the 'subcategoryId' field.
      * @param value The value of 'subcategoryId'.
      * @return This builder.
      */
    public com.acme.avro.hierarchy.Builder setSubcategoryId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.subcategoryId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'subcategoryId' field has been set.
      * @return True if the 'subcategoryId' field has been set, false otherwise.
      */
    public boolean hasSubcategoryId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'subcategoryId' field.
      * @return This builder.
      */
    public com.acme.avro.hierarchy.Builder clearSubcategoryId() {
      subcategoryId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'categoryId' field.
      * @return The value.
      */
    public java.lang.CharSequence getCategoryId() {
      return categoryId;
    }

    /**
      * Sets the value of the 'categoryId' field.
      * @param value The value of 'categoryId'.
      * @return This builder.
      */
    public com.acme.avro.hierarchy.Builder setCategoryId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.categoryId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'categoryId' field has been set.
      * @return True if the 'categoryId' field has been set, false otherwise.
      */
    public boolean hasCategoryId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'categoryId' field.
      * @return This builder.
      */
    public com.acme.avro.hierarchy.Builder clearCategoryId() {
      categoryId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public hierarchy build() {
      try {
        hierarchy record = new hierarchy();
        record.groupId = fieldSetFlags()[0] ? this.groupId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.subcategoryId = fieldSetFlags()[1] ? this.subcategoryId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.categoryId = fieldSetFlags()[2] ? this.categoryId : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<hierarchy>
    WRITER$ = (org.apache.avro.io.DatumWriter<hierarchy>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<hierarchy>
    READER$ = (org.apache.avro.io.DatumReader<hierarchy>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
