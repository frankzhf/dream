package net.frank.framework.thin;

import net.frank.framework.bo.BaseEntity;

public class Condition extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4767986166454903618L;
	
	public static final Integer RELATE_NULL = 0;
	
	public static final Integer RELATE_AND = 1;
	
	public static final Integer RELATE_OR = 2;
	
	public static final Integer RELATE_NOT = 3;
	
	public static final Integer OPERATE_EQUAL = 0;
	
	public static final Integer OPERATE_NOT_EQUAL = 1;
	
	public static final Integer OPERATE_LIKE = 2;
	
	public static final Integer OPERATE_MORE_EQUAL = 3;
	
	public static final Integer OPERATE_LESS_EQUAL = 4;
	
	public static final Integer COLUMN_TYPE_NUMBER = 0;
	
	public static final Integer COLUMN_TYPE_CHAR = 1;
	
	public static final Integer COLUMN_TYPE_DATE = 2;
	
	private Integer relate = RELATE_NULL;
	
	private String columnName;
	
	private Integer columnType = COLUMN_TYPE_NUMBER;
	
	private Integer operate = OPERATE_EQUAL;
	
	private String value;

	public Integer getRelate() {
		return relate;
	}

	public void setRelate(Integer relate) {
		this.relate = relate;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public Integer getColumnType() {
		return columnType;
	}

	public void setColumnType(Integer columnType) {
		this.columnType = columnType;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
}
