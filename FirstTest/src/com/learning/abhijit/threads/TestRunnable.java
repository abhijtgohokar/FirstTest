package com.learning.abhijit.threads;

public class TestRunnable implements Runnable{

	private String name;
	
	public TestRunnable(String name) {
		this.setName(name);
	}
	@Override
	public void run() {
		System.out.println("runnable :" +name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
