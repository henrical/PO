import static java.lang.System.out;

public class Rat extends Animal
{
	//====================Instannce Variables======================

	//====================Class Variables===========================

	//====================Constructors=============================
	public Rat()
	{
		this.energy = 50;
	}
	//====================Instance Methods======================
	public void sleep()
	{
		this.energy = 50;
	}

	public void run()
	{
		this.energy -= 2;
	}

}
