package com.google.code.squashdrills.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.code.squashdrills.dao.model.DataType;
import com.google.code.squashdrills.dao.model.DatabaseTable;
import com.google.code.squashdrills.dao.model.DatabaseTable.Column;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "SquashDrills";
	private static final int DATABASE_VERSION = 1;
	
	private List<DatabaseTable> tables;
	{
		tables = new ArrayList<DatabaseTable>();
		tables.add(new DatabaseTable("routine") {
			{
				addColumn("id", DataType.INTEGER, true);
				addColumn("name", DataType.TEXT);
			}
		});
		
	}
	
	public DatabaseHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		for (DatabaseTable table : tables) {
			createTable(db, table);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO: May be a problem with his, may need to be removed in specific order
		for (DatabaseTable table : tables) {
			dropTable(db, table);
		}
	}
	
	private void createTable(SQLiteDatabase db, DatabaseTable table) {
		String sql = "CREATE TABLE " + table.getName() + "(";
		Iterator<Column> iter = table.getColumns().iterator(); 
		while (iter.hasNext()) {
			Column c = iter.next();
			sql += c.getName() + " " + c.getDataType(); 
			if (c.isPrimaryKey()) {
				sql += " PRIMARY KEY"; 
			}
			if (iter.hasNext()) {
				sql += ", ";
			}
		}
		sql += ");";
		db.execSQL(sql);
	}
	
	private void dropTable(SQLiteDatabase db, DatabaseTable table) {
		String sql = "DROP TABLE IF EXISTS " + table.getName();
		db.execSQL(sql);
	}

}
