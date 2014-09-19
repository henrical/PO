import static java.lang.System.out;
import java.lang.Math;

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
	public void sleep()
	{
		this.energy = 500;
	}

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
		this.run();
		
		if(Math.random() <= (double) 0.2)
			{			
			this.energy += rat.getEnergy();
			rat.energy = 0;
			}

		else 	{
			rat.run();
			rat.energy += 5;
			}
	}

	public void eat(Bird bird)
	{
		this.run();
		
		if(Math.random() <= (double) 0.1)
			{			
			this.energy += bird.getEnergy();
			bird.energy = 0;
			}

		else 	{
			bird.run();
			bird.energy += 5;
			}

	}
}
