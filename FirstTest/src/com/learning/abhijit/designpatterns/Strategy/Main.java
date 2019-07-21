package com.learning.abhijit.designpatterns.Strategy;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		
		Discounter easterDiscounter = amount -> amount.multiply(BigDecimal.valueOf(0.5));
		easterDiscounter.applyDiscount(BigDecimal.valueOf(0.5));
		System.out.println("done");
	}
}
