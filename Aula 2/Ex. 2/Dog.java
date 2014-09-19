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
	@Override	
	public String toString()
	{
		return "Name: "+ this.name + ".\nEnergy: " + this.energy + ".";
	}
}
