package com.google.code.squashdrills.sequencer;

import java.util.Random;

import com.google.code.squashdrills.model.ShotLocation;

public class RandomSequencer implements Sequencer {

	private int numberOfValues = 0; 
	
	public RandomSequencer(int numberOfValues) {
		setNumberOfValues(numberOfValues);
	}
	
	@Override
	public int getNextValue() {
		Random randomiser = new Random();
		return randomiser.nextInt(numberOfValues);
	}

	public int getNumberOfValues() {
		return numberOfValues;
	}

	private void setNumberOfValues(int numberOfValues) {
		this.numberOfValues = numberOfValues;
	}

	@Override
	public boolean hasNextValue() {
		return true;
	}

}
