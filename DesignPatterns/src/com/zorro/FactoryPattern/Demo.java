package com.zorro.FactoryPattern;

public class Demo {
	public static void main(String args[]){
		
		System.out.println("Starting up a factory>>>");
		Factory factory = new Factory();
		Cars car = (Cars)factory.getProduct("cars");
		car.create();
				
		Factory bikes = new Factory();
		Bikes bike = (Bikes)factory.getProduct("bikes");
		bike.create();
	}

}
