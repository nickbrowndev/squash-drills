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
	private int numberOfStations = 6;
	private long delayBetweenStations = 3000;
	private int numberOfReps = 20;
	
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
	
	public void setNumberOfStations(int numberOfStations) {
		this.numberOfStations = numberOfStations;
	}
	
	public int getNumberOfStations() {
		return this.numberOfStations;
	}
	
	/*public void setDelayBetweenStations(double delayBetweenStations) {
		this.delayBetweenStations  = delayBetweenStations / 1000;
	}*/
	
	/*public double getDelayBetweenStations() {
		return this.delayBetweenStations;
	}*/
	
	public long getDelayBetweenStations() {
		return this.delayBetweenStations;
	}

	public int getNumberOfReps() {
		return numberOfReps;
	}

	public void setNumberOfReps(int numberOfReps) {
		this.numberOfReps = numberOfReps;
	}
	
}
