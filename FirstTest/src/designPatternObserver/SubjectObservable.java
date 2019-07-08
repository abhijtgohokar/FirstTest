package designPatternObserver;

import java.util.ArrayList;
import java.util.List;

public class SubjectObservable {

	private String name;
	private List<Observer> observers = new ArrayList<>();
	
	public void setObserver(Observer ob){
		observers.add(ob);
	}
	
	public void setName(String name){
		this.name = name;
		for(Observer ob : observers){
			ob.update(this);
		}
	}
	
	public String getName(){
		return this.name;
	}
}
