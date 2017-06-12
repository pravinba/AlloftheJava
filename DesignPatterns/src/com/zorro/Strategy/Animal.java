package com.zorro.Strategy;

public class Animal {
	
	static Apetite apetite;//carnivorous/herbivorous
	static Habitat habitat;//water/land/both	
	String family;//Example Mammals/Pisces/Amphibians
	//Map<String,String> characteristics = new Map["frog" "amphibian"];
	
	public Animal(String family)
	{
		this.setFamily(family);
		System.out.println("Family -> "+this.family);
	}
	
	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal("Frog");
		
		//Decide & Execute habitat
		String type;
		type="2";
		switch(type)
		{
		case "0":
			habitat = new LivesinLand();
			habitat.Lives();
			break;
		case "1":
			habitat = new LivesinWater();
			habitat.Lives();
			break;
		case "2":
			habitat = new LivesinBoth();
			habitat.Lives();
			break;
		}
		
		//Decide & Execute habitat
		
		type="1";
		switch(type)
		{
		case "0":
			apetite = new Herbivores();
			apetite.Eats();
			break;
		case "1":
			apetite = new Carnivores();
			apetite.Eats();
			break;		
		}
	}

}
