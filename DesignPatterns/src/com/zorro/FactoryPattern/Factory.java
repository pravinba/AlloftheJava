package com.zorro.FactoryPattern;

public class Factory {
	
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
