/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package samples.clickstream.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class demo_transactions extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"demo_transactions\",\"namespace\":\"samples.clickstream.avro\",\"fields\":[{\"name\":\"Account_Id\",\"type\":\"string\"},{\"name\":\"Customer_Name\",\"type\":\"long\"},{\"name\":\"Merchant_Type\",\"type\":\"string\"},{\"name\":\"Transaction_Id\",\"type\":[\"string\",\"null\"]},{\"name\":\"Transaction_Type\",\"type\":[\"string\",\"null\"]},{\"name\":\"Transaction_Amount\",\"type\":\"int\"},{\"name\":\"Transaction_Date\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence Account_Id;
  @Deprecated public long Customer_Name;
  @Deprecated public java.lang.CharSequence Merchant_Type;
  @Deprecated public java.lang.CharSequence Transaction_Id;
  @Deprecated public java.lang.CharSequence Transaction_Type;
  @Deprecated public int Transaction_Amount;
  @Deprecated public java.lang.CharSequence Transaction_Date;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public demo_transactions() {}

  /**
   * All-args constructor.
   */
  public demo_transactions(java.lang.CharSequence Account_Id, java.lang.Long Customer_Name, java.lang.CharSequence Merchant_Type, java.lang.CharSequence Transaction_Id, java.lang.CharSequence Transaction_Type, java.lang.Integer Transaction_Amount, java.lang.CharSequence Transaction_Date) {
    this.Account_Id = Account_Id;
    this.Customer_Name = Customer_Name;
    this.Merchant_Type = Merchant_Type;
    this.Transaction_Id = Transaction_Id;
    this.Transaction_Type = Transaction_Type;
    this.Transaction_Amount = Transaction_Amount;
    this.Transaction_Date = Transaction_Date;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return Account_Id;
    case 1: return Customer_Name;
    case 2: return Merchant_Type;
    case 3: return Transaction_Id;
    case 4: return Transaction_Type;
    case 5: return Transaction_Amount;
    case 6: return Transaction_Date;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: Account_Id = (java.lang.CharSequence)value$; break;
    case 1: Customer_Name = (java.lang.Long)value$; break;
    case 2: Merchant_Type = (java.lang.CharSequence)value$; break;
    case 3: Transaction_Id = (java.lang.CharSequence)value$; break;
    case 4: Transaction_Type = (java.lang.CharSequence)value$; break;
    case 5: Transaction_Amount = (java.lang.Integer)value$; break;
    case 6: Transaction_Date = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'Account_Id' field.
   */
  public java.lang.CharSequence getAccountId() {
    return Account_Id;
  }

  /**
   * Sets the value of the 'Account_Id' field.
   * @param value the value to set.
   */
  public void setAccountId(java.lang.CharSequence value) {
    this.Account_Id = value;
  }

  /**
   * Gets the value of the 'Customer_Name' field.
   */
  public java.lang.Long getCustomerName() {
    return Customer_Name;
  }

  /**
   * Sets the value of the 'Customer_Name' field.
   * @param value the value to set.
   */
  public void setCustomerName(java.lang.Long value) {
    this.Customer_Name = value;
  }

  /**
   * Gets the value of the 'Merchant_Type' field.
   */
  public java.lang.CharSequence getMerchantType() {
    return Merchant_Type;
  }

  /**
   * Sets the value of the 'Merchant_Type' field.
   * @param value the value to set.
   */
  public void setMerchantType(java.lang.CharSequence value) {
    this.Merchant_Type = value;
  }

  /**
   * Gets the value of the 'Transaction_Id' field.
   */
  public java.lang.CharSequence getTransactionId() {
    return Transaction_Id;
  }

  /**
   * Sets the value of the 'Transaction_Id' field.
   * @param value the value to set.
   */
  public void setTransactionId(java.lang.CharSequence value) {
    this.Transaction_Id = value;
  }

  /**
   * Gets the value of the 'Transaction_Type' field.
   */
  public java.lang.CharSequence getTransactionType() {
    return Transaction_Type;
  }

  /**
   * Sets the value of the 'Transaction_Type' field.
   * @param value the value to set.
   */
  public void setTransactionType(java.lang.CharSequence value) {
    this.Transaction_Type = value;
  }

  /**
   * Gets the value of the 'Transaction_Amount' field.
   */
  public java.lang.Integer getTransactionAmount() {
    return Transaction_Amount;
  }

  /**
   * Sets the value of the 'Transaction_Amount' field.
   * @param value the value to set.
   */
  public void setTransactionAmount(java.lang.Integer value) {
    this.Transaction_Amount = value;
  }

  /**
   * Gets the value of the 'Transaction_Date' field.
   */
  public java.lang.CharSequence getTransactionDate() {
    return Transaction_Date;
  }

  /**
   * Sets the value of the 'Transaction_Date' field.
   * @param value the value to set.
   */
  public void setTransactionDate(java.lang.CharSequence value) {
    this.Transaction_Date = value;
  }

  /** Creates a new demo_transactions RecordBuilder */
  public static samples.clickstream.avro.demo_transactions.Builder newBuilder() {
    return new samples.clickstream.avro.demo_transactions.Builder();
  }
  
  /** Creates a new demo_transactions RecordBuilder by copying an existing Builder */
  public static samples.clickstream.avro.demo_transactions.Builder newBuilder(samples.clickstream.avro.demo_transactions.Builder other) {
    return new samples.clickstream.avro.demo_transactions.Builder(other);
  }
  
  /** Creates a new demo_transactions RecordBuilder by copying an existing demo_transactions instance */
  public static samples.clickstream.avro.demo_transactions.Builder newBuilder(samples.clickstream.avro.demo_transactions other) {
    return new samples.clickstream.avro.demo_transactions.Builder(other);
  }
  
  /**
   * RecordBuilder for demo_transactions instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<demo_transactions>
    implements org.apache.avro.data.RecordBuilder<demo_transactions> {

    private java.lang.CharSequence Account_Id;
    private long Customer_Name;
    private java.lang.CharSequence Merchant_Type;
    private java.lang.CharSequence Transaction_Id;
    private java.lang.CharSequence Transaction_Type;
    private int Transaction_Amount;
    private java.lang.CharSequence Transaction_Date;

    /** Creates a new Builder */
    private Builder() {
      super(samples.clickstream.avro.demo_transactions.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(samples.clickstream.avro.demo_transactions.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.Account_Id)) {
        this.Account_Id = data().deepCopy(fields()[0].schema(), other.Account_Id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.Customer_Name)) {
        this.Customer_Name = data().deepCopy(fields()[1].schema(), other.Customer_Name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Merchant_Type)) {
        this.Merchant_Type = data().deepCopy(fields()[2].schema(), other.Merchant_Type);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.Transaction_Id)) {
        this.Transaction_Id = data().deepCopy(fields()[3].schema(), other.Transaction_Id);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.Transaction_Type)) {
        this.Transaction_Type = data().deepCopy(fields()[4].schema(), other.Transaction_Type);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.Transaction_Amount)) {
        this.Transaction_Amount = data().deepCopy(fields()[5].schema(), other.Transaction_Amount);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.Transaction_Date)) {
        this.Transaction_Date = data().deepCopy(fields()[6].schema(), other.Transaction_Date);
        fieldSetFlags()[6] = true;
      }
    }
    
    /** Creates a Builder by copying an existing demo_transactions instance */
    private Builder(samples.clickstream.avro.demo_transactions other) {
            super(samples.clickstream.avro.demo_transactions.SCHEMA$);
      if (isValidValue(fields()[0], other.Account_Id)) {
        this.Account_Id = data().deepCopy(fields()[0].schema(), other.Account_Id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.Customer_Name)) {
        this.Customer_Name = data().deepCopy(fields()[1].schema(), other.Customer_Name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Merchant_Type)) {
        this.Merchant_Type = data().deepCopy(fields()[2].schema(), other.Merchant_Type);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.Transaction_Id)) {
        this.Transaction_Id = data().deepCopy(fields()[3].schema(), other.Transaction_Id);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.Transaction_Type)) {
        this.Transaction_Type = data().deepCopy(fields()[4].schema(), other.Transaction_Type);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.Transaction_Amount)) {
        this.Transaction_Amount = data().deepCopy(fields()[5].schema(), other.Transaction_Amount);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.Transaction_Date)) {
        this.Transaction_Date = data().deepCopy(fields()[6].schema(), other.Transaction_Date);
        fieldSetFlags()[6] = true;
      }
    }

    /** Gets the value of the 'Account_Id' field */
    public java.lang.CharSequence getAccountId() {
      return Account_Id;
    }
    
    /** Sets the value of the 'Account_Id' field */
    public samples.clickstream.avro.demo_transactions.Builder setAccountId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.Account_Id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'Account_Id' field has been set */
    public boolean hasAccountId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'Account_Id' field */
    public samples.clickstream.avro.demo_transactions.Builder clearAccountId() {
      Account_Id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'Customer_Name' field */
    public java.lang.Long getCustomerName() {
      return Customer_Name;
    }
    
    /** Sets the value of the 'Customer_Name' field */
    public samples.clickstream.avro.demo_transactions.Builder setCustomerName(long value) {
      validate(fields()[1], value);
      this.Customer_Name = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'Customer_Name' field has been set */
    public boolean hasCustomerName() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'Customer_Name' field */
    public samples.clickstream.avro.demo_transactions.Builder clearCustomerName() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'Merchant_Type' field */
    public java.lang.CharSequence getMerchantType() {
      return Merchant_Type;
    }
    
    /** Sets the value of the 'Merchant_Type' field */
    public samples.clickstream.avro.demo_transactions.Builder setMerchantType(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.Merchant_Type = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'Merchant_Type' field has been set */
    public boolean hasMerchantType() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'Merchant_Type' field */
    public samples.clickstream.avro.demo_transactions.Builder clearMerchantType() {
      Merchant_Type = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'Transaction_Id' field */
    public java.lang.CharSequence getTransactionId() {
      return Transaction_Id;
    }
    
    /** Sets the value of the 'Transaction_Id' field */
    public samples.clickstream.avro.demo_transactions.Builder setTransactionId(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.Transaction_Id = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'Transaction_Id' field has been set */
    public boolean hasTransactionId() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'Transaction_Id' field */
    public samples.clickstream.avro.demo_transactions.Builder clearTransactionId() {
      Transaction_Id = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'Transaction_Type' field */
    public java.lang.CharSequence getTransactionType() {
      return Transaction_Type;
    }
    
    /** Sets the value of the 'Transaction_Type' field */
    public samples.clickstream.avro.demo_transactions.Builder setTransactionType(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.Transaction_Type = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'Transaction_Type' field has been set */
    public boolean hasTransactionType() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'Transaction_Type' field */
    public samples.clickstream.avro.demo_transactions.Builder clearTransactionType() {
      Transaction_Type = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'Transaction_Amount' field */
    public java.lang.Integer getTransactionAmount() {
      return Transaction_Amount;
    }
    
    /** Sets the value of the 'Transaction_Amount' field */
    public samples.clickstream.avro.demo_transactions.Builder setTransactionAmount(int value) {
      validate(fields()[5], value);
      this.Transaction_Amount = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'Transaction_Amount' field has been set */
    public boolean hasTransactionAmount() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'Transaction_Amount' field */
    public samples.clickstream.avro.demo_transactions.Builder clearTransactionAmount() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'Transaction_Date' field */
    public java.lang.CharSequence getTransactionDate() {
      return Transaction_Date;
    }
    
    /** Sets the value of the 'Transaction_Date' field */
    public samples.clickstream.avro.demo_transactions.Builder setTransactionDate(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.Transaction_Date = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'Transaction_Date' field has been set */
    public boolean hasTransactionDate() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'Transaction_Date' field */
    public samples.clickstream.avro.demo_transactions.Builder clearTransactionDate() {
      Transaction_Date = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    public demo_transactions build() {
      try {
        demo_transactions record = new demo_transactions();
        record.Account_Id = fieldSetFlags()[0] ? this.Account_Id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.Customer_Name = fieldSetFlags()[1] ? this.Customer_Name : (java.lang.Long) defaultValue(fields()[1]);
        record.Merchant_Type = fieldSetFlags()[2] ? this.Merchant_Type : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.Transaction_Id = fieldSetFlags()[3] ? this.Transaction_Id : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.Transaction_Type = fieldSetFlags()[4] ? this.Transaction_Type : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.Transaction_Amount = fieldSetFlags()[5] ? this.Transaction_Amount : (java.lang.Integer) defaultValue(fields()[5]);
        record.Transaction_Date = fieldSetFlags()[6] ? this.Transaction_Date : (java.lang.CharSequence) defaultValue(fields()[6]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
