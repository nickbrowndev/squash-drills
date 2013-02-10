package com.google.code.squashdrills.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import android.os.CountDownTimer;
import android.util.Log;

import com.google.code.squashdrills.listener.ActionCompleteListener;
import com.google.code.squashdrills.listener.ValueChangeListener;
import com.google.code.squashdrills.model.Routine;
import com.google.code.squashdrills.sequencer.RandomSequencer;
import com.google.code.squashdrills.sequencer.Sequencer;
import com.google.code.squashdrills.sound.SoundManager;

public class RoutineRunner {

	private boolean runRoutine = false;
	private Routine routine;
	private Sequencer randomSequencer;
	private int currentValue;
	private Integer numberOfReps = null;
	


	private List<ValueChangeListener<Integer>> nextValueListeners = new ArrayList<ValueChangeListener<Integer>>();
	private List<ActionCompleteListener> routineCompleteListener = new ArrayList<ActionCompleteListener>();
	private ScheduledExecutorService scheduler =  Executors.newScheduledThreadPool(1);
	final SoundManager soundManager = new SoundManager(1.0f);
	
	public RoutineRunner(Routine routine) {
		// ignore set routine, use default for now
		// setRoutine(routine);
		Routine defaultRoutine = new Routine("Default Routine");
		
		setRoutine(defaultRoutine);
		
		randomSequencer = new RandomSequencer(getRoutine().getNumberOfStations());
		
		Log.d(this.getClass().getName(), "RoutineRunner instantiated");
	}
	
	public void start() {
		Log.d(this.getClass().getName(), "RoutineRunner started");
		runRoutine = true;
		//runningRoutine = new Thread(
		//ScheduledFuture mainRunner = scheduler.scheduleAtFixedRate(
		Runnable routineRunner = new Runnable() {

			@Override
			public void run() {		
				if (randomSequencer.hasNextValue()) {
					setCurrentValue(randomSequencer.getNextValue() + 1);
					Log.d(this.getClass().getName(), "Set Value to " + getCurrentValue());
				}
			}


		};
		
		ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(routineRunner, 0, routine.getDelayBetweenStations(), TimeUnit.MILLISECONDS);
		
		//, 10, routine.getDelayBetweenStations(), TimeUnit.MILLISECONDS);
		Log.d(this.getClass().getName(), "RoutineSchedulor started");
		
		
	}
	
	
	public void stop() {
		scheduler.shutdownNow();
	}
	
	private void setRoutine(Routine routine) {
		this.routine = routine;
	}
	
	public Routine getRoutine() {
		return this.routine;
	}
	
	public void addNextValueListener(ValueChangeListener<Integer> listener) {
		nextValueListeners.add(listener);
	}
	
	public void addRoutineCompleteListener(ActionCompleteListener listener) {
		routineCompleteListener.add(listener);
	}
	
	public void removeNextValueListener(ValueChangeListener<Integer> listener) {
		nextValueListeners.remove(listener);
	}
	
	private void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
		Log.d(this.getClass().getName(), "Value changed to: " + currentValue + ". Notifying listeners...");
		for (ValueChangeListener<Integer> listener : nextValueListeners) {
			listener.notifyValueChanged(currentValue);
		}
	}
	
	private int getCurrentValue() {
		return currentValue;
	}
	
	private Integer getNumberOfReps() {
		return numberOfReps;
	}

	private void setNumberOfReps(Integer numberOfReps) {
		this.numberOfReps = numberOfReps;
	}
}

// Start
// Stop
// Pause
// Change Location