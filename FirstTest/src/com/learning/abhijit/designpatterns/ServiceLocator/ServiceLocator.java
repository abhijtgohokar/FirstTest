package com.learning.abhijit.designpatterns.ServiceLocator;

public class ServiceLocator {

	public Service getService(String serviceName) {
		System.out.println("locating service..");
		return ServiceCache.getService(serviceName);
	}
	
}
