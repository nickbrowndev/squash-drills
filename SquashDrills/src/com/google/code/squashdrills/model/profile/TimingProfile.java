package com.google.code.squashdrills.model.profile;

public class TimingProfile {

	private double shotTime;
	private int shotTimePercentage;
	private int restTimeBetweenSets;
	
	public TimingProfile() {
	}
	
	public double getShotTime() {
		return shotTime;
	}

	public void setShotTime(double shotTime) {
		this.shotTime = shotTime;
	}

	public int getShotTimePercentage() {
		return shotTimePercentage;
	}

	public void setShotTimePercentage(int shotTimePercentage) {
		this.shotTimePercentage = shotTimePercentage;
	}

}
