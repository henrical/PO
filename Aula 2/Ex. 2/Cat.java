import static java.lang.System.out;

public class Cat extends Animal
{
	//====================Instannce Variables======================
	private	String name;

	//====================Class Variables===========================

	//====================Constructors=============================
	public Cat(String name)
	{
		this.name = name;
		this.energy = 500;
	}
	//====================Instance Methods======================
	@Override	
	public String toString()
	{
		return "Name: "+ this.name + ".\nEnergy: " + this.energy + ".\n";
	}
	
	public void run()
	{
		this.energy -= 25;
	}

	public void eat(Rat rat)
	{
		this.energy += rat.getEnergy();
		rat.energy = 0;
	}

	public void eat(Bird bird)
	{
		this.energy += bird.getEnergy();
		bird.energy = 0;
	}
}
