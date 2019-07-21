package com.learning.abhijit.designpatterns.ServiceLocator;

public class MainClassServiceLocator {

	public static void main(String[] args) {
		ServiceLocator locator = new ServiceLocator();
		Service service = locator.getService("service2");
		System.out.println(service.getName());
	}
}
