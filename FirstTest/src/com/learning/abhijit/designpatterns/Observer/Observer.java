package com.learning.abhijit.designpatterns.Observer;

public class Observer {

	public void update(SubjectObservable ob){
		System.out.println("Observer is notified of name chane to :"+ob.getName());
	}
}
