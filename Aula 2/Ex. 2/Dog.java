import static java.lang.System.out;

public class Dog extends Animal
{
	//====================Instannce Variables======================
	private	String name;

	//====================Class Variables===========================

	//====================Constructors=============================
	public Dog(String name)
	{
		this.name = name;
		this.energy = 1000;
	}
	//====================Instance Methods======================
	public void sleep()
	{
		this.energy = 1000;
	}
	
	@Override	
	public String toString()
	{
		return "Name: "+ this.name + ".\nEnergy: " + this.energy + ".\n";
	}

	public void run()
	{
		this.energy -= 50;
	}


	public void attack(Cat cat)
	{
		this.energy -= 100;
		cat.energy -= 25;
	}

	public void eat(Rat rat)
	{
		this.run();
		
		if(Math.random() <= (double) 0.04)
			{			
			this.energy += rat.getEnergy();
			rat.energy = 0;
			}

		else 	{
			rat.run();
			rat.energy += 5;
			}
	}
}
