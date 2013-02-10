package com.google.code.squashdrills.runner;

import java.util.List;
import java.util.ArrayList;

import com.google.code.squashdrills.listener.ActionCompleteListener;
import com.google.code.squashdrills.listener.ValueChangeListener;

import android.os.CountDownTimer;

public class CountDownSecondsTimer extends android.os.CountDownTimer {

	private static final long SECOND_IN_MILLIS = 1000;
	
	private final List<ValueChangeListener<Integer>> tickListeners = new ArrayList<ValueChangeListener<Integer>>();
	private final List<ActionCompleteListener> finishListeners = new ArrayList<ActionCompleteListener>();
	
	public CountDownSecondsTimer(int countdownLength) {
		super(countdownLength * SECOND_IN_MILLIS, SECOND_IN_MILLIS);
	}



	@Override
	public void onTick(long millisUntilFinished) {
		for (ValueChangeListener<Integer> listener : tickListeners) {
			listener.notifyValueChanged((int) (millisUntilFinished / SECOND_IN_MILLIS));
		}
	}
	
	@Override
	public void onFinish() {
		for (ActionCompleteListener listener : finishListeners) {
			listener.notifyComplete();
		}
	}
	
	public void addTickListener(ValueChangeListener<Integer> listener) {
		tickListeners.add(listener);
	}
	
	public void addFinishListener(ActionCompleteListener listener) {
		finishListeners.add(listener);
	}

}
