package net.frank.framework.hibernate.dialect;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;

public class MysqlDialect extends MySQLDialect {
	
	public MysqlDialect(){
		super();
		registerHibernateType( Types.LONGVARCHAR, Hibernate.CHAR_ARRAY.getName() );
		registerHibernateType( Types.REAL, Hibernate.FLOAT.getName() );
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
			rt = Hibernate.BIG_INTEGER.getReturnedClass();
			break;
		case Types.BINARY:
			rt = Hibernate.BINARY.getReturnedClass();
			break;
		case Types.BIT:
			rt = Hibernate.BOOLEAN.getReturnedClass();
			break;
		case Types.CHAR:
			if(size ==1){
				rt = Hibernate.CHARACTER.getReturnedClass();
			}else{
				rt = Hibernate.STRING.getReturnedClass();
			}
			break;
		case Types.DATE:
			rt = Hibernate.DATE.getReturnedClass();
			break;	
		case Types.DOUBLE:
			rt = Hibernate.DOUBLE.getReturnedClass();
			break;
		case Types.FLOAT:
			rt = Hibernate.BIG_DECIMAL.getReturnedClass();
			break;
		case Types.INTEGER:
			rt = Hibernate.INTEGER.getReturnedClass();
			break;	
		case Types.SMALLINT:
			rt = Hibernate.INTEGER.getReturnedClass();
			break;
		case Types.TINYINT:
			rt = Hibernate.BYTE.getReturnedClass();
			break;
		case Types.TIME:
			rt = Hibernate.TIME.getReturnedClass();
			break;	
		case Types.TIMESTAMP:
			rt = Hibernate.TIMESTAMP.getReturnedClass();
			break;
		case Types.VARCHAR:
			rt = Hibernate.STRING.getReturnedClass();
			break;
		case Types.VARBINARY:
			rt = Hibernate.BINARY.getReturnedClass();
			break;
		case Types.NUMERIC:
			rt = Hibernate.BIG_DECIMAL.getReturnedClass();
			break;	
		case Types.DECIMAL:
			rt = Hibernate.BIG_DECIMAL.getReturnedClass();
			break;
		case Types.BLOB:
			rt = Hibernate.BLOB.getReturnedClass();
			break;
		case Types.CLOB:
			rt = Hibernate.CLOB.getReturnedClass();
			break;	
		case Types.LONGVARCHAR:
			rt = Hibernate.CHAR_ARRAY.getReturnedClass();
			break;
		case Types.REAL:
			rt = Hibernate.FLOAT.getReturnedClass();
			break;
		}
		return rt;
	}
}
