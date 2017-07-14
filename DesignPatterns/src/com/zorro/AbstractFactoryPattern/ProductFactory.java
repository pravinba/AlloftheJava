package com.zorro.AbstractFactoryPattern;

public class ProductFactory extends AbstractFactory {
	

	public Product getProduct(String auto)
	{
		switch(auto)
		{
		case "cars":
			return new Cars();
			
		case "bikes":
			return new Bikes();
		}
		return null;
	}


}
