import static java.lang.System.out;

public class Animal
{
	//====================Instannce Variables======================
	protected int energy;

	//====================Class Variables===========================

	//====================Constructors=============================
	public Animal()
	{
		this.energy = 0;
	}
	//====================Getters and Setters=====================

	public int getEnergy()
	{
		return this.energy;
	}
	
	//====================Instance Methods======================
	public String toString()
	{
		return "Energy: " + this.energy + ".";
	}

}
