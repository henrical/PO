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
		return "Name: "+ this.name + ".\nEnergy: " + this.energy + ".";
	}
}
