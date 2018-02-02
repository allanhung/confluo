/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package confluo.rpc;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)")
public class rpc_column implements org.apache.thrift.TBase<rpc_column, rpc_column._Fields>, java.io.Serializable, Cloneable, Comparable<rpc_column> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("rpc_column");

  private static final org.apache.thrift.protocol.TField TYPE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("typeId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TYPE_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("type_size", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new rpc_columnStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new rpc_columnTupleSchemeFactory();

  private int type_id; // required
  private int type_size; // required
  private java.lang.String name; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TYPE_ID((short)1, "typeId"),
    TYPE_SIZE((short)2, "type_size"),
    NAME((short)3, "name");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TYPE_ID
          return TYPE_ID;
        case 2: // TYPE_SIZE
          return TYPE_SIZE;
        case 3: // NAME
          return NAME;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TYPE_ID_ISSET_ID = 0;
  private static final int __TYPE_SIZE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TYPE_ID, new org.apache.thrift.meta_data.FieldMetaData("typeId", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TYPE_SIZE, new org.apache.thrift.meta_data.FieldMetaData("type_size", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(rpc_column.class, metaDataMap);
  }

  public rpc_column() {
  }

  public rpc_column(
    int type_id,
    int type_size,
    java.lang.String name)
  {
    this();
    this.type_id = type_id;
    set_type_id_isSet(true);
    this.type_size = type_size;
    set_type_size_isSet(true);
    this.name = name;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public rpc_column(rpc_column other) {
    __isset_bitfield = other.__isset_bitfield;
    this.type_id = other.type_id;
    this.type_size = other.type_size;
    if (other.is_set_name()) {
      this.name = other.name;
    }
  }

  public rpc_column deepCopy() {
    return new rpc_column(this);
  }

  @Override
  public void clear() {
    set_type_id_isSet(false);
    this.type_id = 0;
    set_type_size_isSet(false);
    this.type_size = 0;
    this.name = null;
  }

  public int get_type_id() {
    return this.type_id;
  }

  public rpc_column set_type_id(int type_id) {
    this.type_id = type_id;
    set_type_id_isSet(true);
    return this;
  }

  public void unset_type_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TYPE_ID_ISSET_ID);
  }

  /** Returns true if Field typeId is set (has been assigned a value) and false otherwise */
  public boolean is_set_type_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TYPE_ID_ISSET_ID);
  }

  public void set_type_id_isSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TYPE_ID_ISSET_ID, value);
  }

  public int get_type_size() {
    return this.type_size;
  }

  public rpc_column set_type_size(int type_size) {
    this.type_size = type_size;
    set_type_size_isSet(true);
    return this;
  }

  public void unset_type_size() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TYPE_SIZE_ISSET_ID);
  }

  /** Returns true if Field type_size is set (has been assigned a value) and false otherwise */
  public boolean is_set_type_size() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TYPE_SIZE_ISSET_ID);
  }

  public void set_type_size_isSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TYPE_SIZE_ISSET_ID, value);
  }

  public java.lang.String get_name() {
    return this.name;
  }

  public rpc_column set_name(java.lang.String name) {
    this.name = name;
    return this;
  }

  public void unset_name() {
    this.name = null;
  }

  /** Returns true if Field name is set (has been assigned a value) and false otherwise */
  public boolean is_set_name() {
    return this.name != null;
  }

  public void set_name_isSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case TYPE_ID:
      if (value == null) {
        unset_type_id();
      } else {
        set_type_id((java.lang.Integer)value);
      }
      break;

    case TYPE_SIZE:
      if (value == null) {
        unset_type_size();
      } else {
        set_type_size((java.lang.Integer)value);
      }
      break;

    case NAME:
      if (value == null) {
        unset_name();
      } else {
        set_name((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TYPE_ID:
      return get_type_id();

    case TYPE_SIZE:
      return get_type_size();

    case NAME:
      return get_name();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if Field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case TYPE_ID:
      return is_set_type_id();
    case TYPE_SIZE:
      return is_set_type_size();
    case NAME:
      return is_set_name();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof rpc_column)
      return this.equals((rpc_column)that);
    return false;
  }

  public boolean equals(rpc_column that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_type_id = true;
    boolean that_present_type_id = true;
    if (this_present_type_id || that_present_type_id) {
      if (!(this_present_type_id && that_present_type_id))
        return false;
      if (this.type_id != that.type_id)
        return false;
    }

    boolean this_present_type_size = true;
    boolean that_present_type_size = true;
    if (this_present_type_size || that_present_type_size) {
      if (!(this_present_type_size && that_present_type_size))
        return false;
      if (this.type_size != that.type_size)
        return false;
    }

    boolean this_present_name = true && this.is_set_name();
    boolean that_present_name = true && that.is_set_name();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + type_id;

    hashCode = hashCode * 8191 + type_size;

    hashCode = hashCode * 8191 + ((is_set_name()) ? 131071 : 524287);
    if (is_set_name())
      hashCode = hashCode * 8191 + name.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(rpc_column other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(is_set_type_id()).compareTo(other.is_set_type_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_type_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type_id, other.type_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(is_set_type_size()).compareTo(other.is_set_type_size());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_type_size()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type_size, other.type_size);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(is_set_name()).compareTo(other.is_set_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("rpc_column(");
    boolean first = true;

    sb.append("typeId:");
    sb.append(this.type_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type_size:");
    sb.append(this.type_size);
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'typeId' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'type_size' because it's a primitive and you chose the non-beans generator.
    if (name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required Field 'name' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class rpc_columnStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public rpc_columnStandardScheme getScheme() {
      return new rpc_columnStandardScheme();
    }
  }

  private static class rpc_columnStandardScheme extends org.apache.thrift.scheme.StandardScheme<rpc_column> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, rpc_column struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TYPE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type_id = iprot.readI32();
              struct.set_type_id_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TYPE_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type_size = iprot.readI32();
              struct.set_type_size_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.set_name_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.is_set_type_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required Field 'typeId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.is_set_type_size()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required Field 'type_size' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, rpc_column struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TYPE_ID_FIELD_DESC);
      oprot.writeI32(struct.type_id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TYPE_SIZE_FIELD_DESC);
      oprot.writeI32(struct.type_size);
      oprot.writeFieldEnd();
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class rpc_columnTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public rpc_columnTupleScheme getScheme() {
      return new rpc_columnTupleScheme();
    }
  }

  private static class rpc_columnTupleScheme extends org.apache.thrift.scheme.TupleScheme<rpc_column> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, rpc_column struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.type_id);
      oprot.writeI32(struct.type_size);
      oprot.writeString(struct.name);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, rpc_column struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.type_id = iprot.readI32();
      struct.set_type_id_isSet(true);
      struct.type_size = iprot.readI32();
      struct.set_type_size_isSet(true);
      struct.name = iprot.readString();
      struct.set_name_isSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

