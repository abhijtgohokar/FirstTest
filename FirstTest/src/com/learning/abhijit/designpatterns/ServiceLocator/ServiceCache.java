package com.learning.abhijit.designpatterns.ServiceLocator;

import java.util.HashMap;
import java.util.Map;

public class ServiceCache {

	private static Map<String, Service> cache = new HashMap<>();
	
	public static  Service getService(String serviceName) {
		if(!cache.containsKey(serviceName)) {
			synchronized (cache) {
				
				Service service = InitialContext.lookup(serviceName);
				System.out.println("adding in cache..");
				cache.put(serviceName, service);	
			}
			
		}
		return cache.get(serviceName);
	}
}
