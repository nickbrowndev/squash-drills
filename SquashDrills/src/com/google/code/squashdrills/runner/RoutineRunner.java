package com.google.code.squashdrills.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.util.Log;

import com.google.code.squashdrills.listener.ValueChangeListener;
import com.google.code.squashdrills.model.Routine;
import com.google.code.squashdrills.sequencer.RandomSequencer;
import com.google.code.squashdrills.sequencer.Sequencer;
import com.google.code.squashdrills.sound.SoundManager;

public class RoutineRunner {

	private boolean runRoutine = false;
	private Routine routine;
	private Sequencer randomSequencer;
	private Sequencer countdownSequencer;
	private int currentValue;
	
	private List<ValueChangeListener> valueChangeListeners = new ArrayList<ValueChangeListener>();
	ScheduledExecutorService scheduler =  Executors.newScheduledThreadPool(1);
	
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
		Callable<?> routineRunner = Executors.callable(new Runnable() {

			@Override
			public void run() {		
				while (randomSequencer.hasNextValue()) {
					setCurrentValue(randomSequencer.getNextValue() + 1);
					Log.d(this.getClass().getName(), "Set Value to " + getCurrentValue());
				}
			}


		});
		
		Callable<?> countdownRunner = Executors.callable(new Runnable() {

			@Override
			public void run() {		
				while (countdownSequencer.hasNextValue()) {
					setCurrentValue(countdownSequencer.getNextValue());
				}
			}
		});
		
		final SoundManager soundManager = new SoundManager(1.0f);
		
		Callable<?> countdownShortBeep = Executors.callable(new Runnable() {

			@Override
			public void run() {		
				soundManager.playCountdownShortBeep();
			}
		});
		
		Callable<?> countdownLongBeep = Executors.callable(new Runnable() {

			@Override
			public void run() {		
				soundManager.playCountdownShortBeep();
			}
		});
		
		
		
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
	
	public void addValueChangeListener(ValueChangeListener listener) {
		valueChangeListeners.add(listener);
	}
	
	public void removeValueChangeListener(ValueChangeListener listener) {
		valueChangeListeners.remove(listener);
	}
	
	private void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
		Log.d(this.getClass().getName(), "Value changed to: " + currentValue + ". Notifying listeners...");
		for (ValueChangeListener listener : valueChangeListeners) {
			listener.notifyValueChanged(currentValue);
		}
	}
	
	private int getCurrentValue() {
		return currentValue;
	}
}

// Start
// Stop
// Pause
// Change Location