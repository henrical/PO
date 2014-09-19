

import static java.lang.System.out;

public class Cat
{
	//====================Instannce Variables======================
	private	int age;
	private String name;
	private	float weight;

	//====================Class Variables===========================
	
	public final static String sound= new String("MEOW");

	//====================Constructors=============================
	
	public Cat(int age, String name, float weight)
	{
		this.age = age;
		this.name = name;
		this.weight= weight;
	}

	public Cat()
	{
		this.age = 0;
		this.name = "Placeholder";
		this.weight = 0;
	}
	//====================Getters and Setters=====================

	public int getCatAge()
	{
		return this.age;
	}

	public String getCatName()
	{
		return this.name;
	}

	public float getCatWeight()
	{
		return this.weight;
	}
	
	
}
