package com.learning.abhijit.designpatterns.ServiceLocator;

public class InitialContext {

public static Service lookup(String serviceName) {
		
	System.out.println("looking up....");
		if("SERVICE1".equalsIgnoreCase(serviceName)) {
			return new Service1();
		}else if("SERVICE2".equalsIgnoreCase(serviceName)) {
			return new Service2();
		}
		return null;
	}
}
