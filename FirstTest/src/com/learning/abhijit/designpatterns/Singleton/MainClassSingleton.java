package com.learning.abhijit.designpatterns.Singleton;

public class MainClassSingleton {

public static void main(String[] args) {
	SingletonPattern sp = SingletonPattern.INSTANCE;
	SingletonPattern sp1 = SingletonPattern.INSTANCE;
	
	System.out.println(sp1==sp?"true":"false");
	System.out.println(sp.equals(sp)?"true":"false");
}
}
