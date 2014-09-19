import static java.lang.System.out;

public class Cat
{
	//====================Instannce Variables======================
	private	int age;
	private String name;
	private	float weight;

	//====================Class Variables===========================

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
		this.name = "";
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
	
	//====================Instance Methods======================
	public boolean equals(Cat cat)
	{
		if(this.age != cat.age)
			return false;

		if(this.name != cat.name)
			return false;

		if(this.weight != cat.weight)
			return false;

		return true;
	}

	@Override
	public String toString()
	{
		return "New cat's name is '" + this.getCatName() + "', and it's age is " +this.getCatAge() + ". It weighs " + this.getCatWeight() + " pounds.";
	}


}
