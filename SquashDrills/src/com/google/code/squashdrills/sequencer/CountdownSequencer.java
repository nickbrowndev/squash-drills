package com.google.code.squashdrills.sequencer;

import java.util.Random;

public class CountdownSequencer implements Sequencer {

private int currentValue;
private static int MIN_VALUE = 0;
	
	public CountdownSequencer(int initialValue) {
		setCurrentValue(initialValue);
	}
	
	@Override
	public int getNextValue() {
		if (currentValue == MIN_VALUE) {
			throw new RuntimeException("Sequencer out of bounds");
		}
		return currentValue--; 
	}

	private void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	@Override
	public boolean hasNextValue() {
		return currentValue > MIN_VALUE;
	}	
	
}
