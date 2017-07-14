package com.zorro.AbstractFactoryPattern;

public class ProductBuilder {
	public static AbstractFactory getFactory()
	{
		return new ProductFactory();
	}


}
