package com.google.code.squashdrills.runner;

import com.google.code.squashdrills.listener.ActionCompleteListener;
import com.google.code.squashdrills.listener.ValueChangeListener;

public class RoutineCoordinator {

	private RoutineRunner runner = new RoutineRunner(null);
	private CountDownSecondsTimer countdownTimer = new CountDownSecondsTimer(10);
	
	public RoutineCoordinator() {
		
		// Set up the runner to start when the countdown stops
		addCountdownTimerCompleteListener(new ActionCompleteListener() {

			@Override
			public void notifyComplete() {
				runner.start();
			}
		});
	}
	
	public void run() {
		countdownTimer.start();
	}
	
	public void stop() {
		countdownTimer.cancel();
		runner.stop();
	}
		
	public void addCountdownTimerTickListener(ValueChangeListener<Integer> listener) {
		countdownTimer.addTickListener(listener);
	}
	
	public void addCountdownTimerCompleteListener(ActionCompleteListener listener) {
		countdownTimer.addFinishListener(listener);
	}
	
	public void addRoutineRunnerNextValueListener(ValueChangeListener<Integer> listener) {
		runner.addNextValueListener(listener);
	}
	
	public void addRoutineCompleteListener(ActionCompleteListener listener) {
		runner.addRoutineCompleteListener(listener);
	}
}
