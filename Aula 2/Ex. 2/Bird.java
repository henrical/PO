import static java.lang.System.out;

public class Bird extends Animal
{
	//====================Instannce Variables======================

	//====================Class Variables===========================

	//====================Constructors=============================
	public Bird()
	{
		this.energy = 20;
	}
	//====================Instance Methods======================
	public void run()
	{
		this.energy -= 5;
	}

	public void fly()
	{
		this.energy -= 2;
	}

	public void sleep()
	{
		this.energy = 20;
	}

}
