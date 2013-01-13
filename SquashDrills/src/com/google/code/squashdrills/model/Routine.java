package com.google.code.squashdrills.model;

import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "routines")
public class Routine {

	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private String name;
	
	public Routine() {
		
	}
	
	public Routine(String name) {
		setName(name);
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
