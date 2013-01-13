package com.google.code.squashdrills.dao.model;

import java.util.ArrayList;
import java.util.List;

public class DatabaseTable {

	private String name;
	private List<Column> columns = new ArrayList<Column>();
	
	public DatabaseTable(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void addColumn(String name, DataType dataType) {
		Column c = new Column(name, dataType);
		getColumns().add(c);
	}
	
	public void addColumn(String name, DataType dataType, boolean primaryKey) {
		Column c = new Column(name, dataType, primaryKey);
		getColumns().add(c);
	}
	
	public class Column {

		private String name; 
		private DataType dataType;
		private boolean primaryKey = false;
		
		private Column(String name, DataType dataType) {
			setName(name);
			setDataType(dataType);
		}
		
		private Column(String name, DataType dataType, boolean primaryKey) {
			setName(name);
			setDataType(dataType);
			setPrimaryKey(primaryKey);
		}
		
		public String getName() {
			return name;
		}

		private void setName(String name) {
			this.name = name;
		}

		public DataType getDataType() {
			return dataType;
		}

		private void setDataType(DataType dataType) {
			this.dataType = dataType;
		}

		public boolean isPrimaryKey() {
			return primaryKey;
		}

		private void setPrimaryKey(boolean primaryKey) {
			this.primaryKey = primaryKey;
		}

	}

}
