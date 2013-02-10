package com.google.code.squashdrills.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunnableSequencer implements Runnable {
	
	private List<Runnable> sequence = new ArrayList<Runnable>();

	public RunnableSequencer() {
	}
	
	public RunnableSequencer(Runnable... runnables) {
		addToSequence(Arrays.asList(runnables));
	}
	
	public void addToSequence(Runnable runnable) {
		sequence.add(runnable);
	}
	
	public void addToSequence(List<Runnable> runnables) {
		sequence.addAll(runnables);
	}

	@Override
	public void run() {
		for (Runnable runnable : sequence) {
			runnable.run();
		}
	}
	
}
