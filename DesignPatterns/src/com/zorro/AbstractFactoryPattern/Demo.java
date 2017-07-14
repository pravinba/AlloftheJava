package com.zorro.AbstractFactoryPattern;

public class Demo {
	public static void main(String args[]){
		
		System.out.println("Starting up a factory>>>");
		AbstractFactory factory = ProductBuilder.getFactory();
		
		Cars car = (Cars)factory.getProduct("cars");
		car.create();
				
		Bikes bike = (Bikes)factory.getProduct("bikes");
		bike.create();
	}

}
