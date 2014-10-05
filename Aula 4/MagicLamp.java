package arabiannights;

public class MagicLamp
{	
	private int timesRubbed;
	private int genies;
	private int demons;
	private final int initGenies;


	public MagicLamp(int a)
	{
		this.genies = a;
		this.initGenies = a;
	}

	public boolean equals(MagicLamp m)
	{
		return (initGenies == m.initGenies) 
			&& (getDemons() == m.getDemons()) 
			&& (getGenies() == m.getGenies());
	}

	public int getTimesRubbed()
	{
		return this.timesRubbed;
	}

	public int getGenies()
	{
		return this.genies;
	}

	public int getDemons()
	{
		return demons;
	}	


	public MagicalEntity rub(int x)
	{
		if(genies==0)
		{
			Demon d = new Demon(x);
			return d;
		} 
		else if(timesRubbed%2==0) 
		{
			GrumpyGenie g = new GrumpyGenie(x);
			return g;
		}
		else  
		{
			FriendlyGenie g = new FriendlyGenie(x);
			return g;
		}			
	}



	public void feedDemon(Demon d)
	{
		this.genies = initGenies;
		this.demons++;

		d.hasBeenRecycled = true;
	}
}
