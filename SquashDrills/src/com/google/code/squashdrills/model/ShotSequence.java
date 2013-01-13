package com.google.code.squashdrills.model;

import java.util.ArrayList;
import java.util.List;

public class ShotSequence {

	private List<ShotLocation> locations = new ArrayList<ShotLocation>();

	private int repetitions;
	
	public ShotSequence() {
	}
	
	public int getRepetitions() {
		return repetitions;
	}
	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}
	public List<ShotLocation> getLocations() {
		return locations;
	}
	public void addLocation(ShotLocation location) {
		getLocations().add(location);
	}
	public void removeLocation(ShotLocation location) {
		getLocations().remove(location);
	}
	private void setLocations(List<ShotLocation> locations) {
		this.locations = locations;
	}
}
