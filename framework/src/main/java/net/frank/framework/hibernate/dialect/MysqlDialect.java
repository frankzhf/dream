package net.frank.framework.hibernate.dialect;

import java.sql.Types;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.BigIntegerType;
import org.hibernate.type.BinaryType;
import org.hibernate.type.BlobType;
import org.hibernate.type.BooleanType;
import org.hibernate.type.ByteType;
import org.hibernate.type.CharArrayType;
import org.hibernate.type.CharacterType;
import org.hibernate.type.ClobType;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.ShortType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimeType;
import org.hibernate.type.TimestampType;

public class MysqlDialect extends MySQLDialect {
	
	public MysqlDialect(){
		super();
		registerHibernateType( Types.LONGVARCHAR, CharArrayType.INSTANCE.getName() );
		registerHibernateType( Types.REAL, FloatType.INSTANCE.getName());
	}
	
	protected void registerVarcharTypes() {
		registerColumnType( Types.VARCHAR, "longtext" );
		registerColumnType( Types.VARCHAR, 16777215, "mediumtext" );
		registerColumnType( Types.VARCHAR, 65535, "text" );
		registerColumnType( Types.VARCHAR, 255, "varchar($l)" );
		registerColumnType( Types.LONGVARCHAR, 16777215, "mediumtext" );
		registerColumnType( Types.REAL, "float" );
	}
	
	public Class<?> getJavaClass(int typeCode,int size){
		Class<?> rt = null;
		switch(typeCode){
		case Types.BIGINT:
			rt = BigIntegerType.INSTANCE.getReturnedClass();
			break;
		case Types.BINARY:
			rt = BinaryType.INSTANCE.getReturnedClass();
			break;
		case Types.BIT:
			rt = BooleanType.INSTANCE.getReturnedClass();
			break;
		case Types.CHAR:
			if(size ==1){
				rt = CharacterType.INSTANCE.getReturnedClass();
			}else{
				rt = StringType.INSTANCE.getReturnedClass();
			}
			break;
		case Types.DATE:
			rt = DateType.INSTANCE.getReturnedClass();
			break;	
		case Types.DOUBLE:
			rt = DoubleType.INSTANCE.getReturnedClass();
			break;
		case Types.FLOAT:
			rt = FloatType.INSTANCE.getReturnedClass();
			break;
		case Types.INTEGER:
			rt = IntegerType.INSTANCE.getReturnedClass();
			break;	
		case Types.SMALLINT:
			rt = ShortType.INSTANCE.getReturnedClass();
			break;
		case Types.TINYINT:
			rt = ByteType.INSTANCE.getReturnedClass();
			break;
		case Types.TIME:
			rt = TimeType.INSTANCE.getReturnedClass();
			break;	
		case Types.TIMESTAMP:
			rt = TimestampType.INSTANCE.getReturnedClass();
			break;
		case Types.VARCHAR:
			rt = StringType.INSTANCE.getReturnedClass();
			break;
		case Types.VARBINARY:
			rt = BinaryType.INSTANCE.getReturnedClass();
			break;
		case Types.NUMERIC:
			rt = BigDecimalType.INSTANCE.getReturnedClass();
			break;	
		case Types.DECIMAL:
			rt = BigDecimalType.INSTANCE.getReturnedClass();
			break;
		case Types.BLOB:
			rt = BlobType.INSTANCE.getReturnedClass();
			break;
		case Types.CLOB:
			rt = ClobType.INSTANCE.getReturnedClass();
			break;	
		case Types.LONGVARCHAR:
			rt = CharArrayType.INSTANCE.getReturnedClass();
			break;
		case Types.REAL:
			rt = FloatType.INSTANCE.getReturnedClass();
			break;
		}
		return rt;
	}
}
