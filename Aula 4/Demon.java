package arabiannights;

public class Demon extends MagicalEntity
{
	public boolean hasBeenRecycled = false;

	public Demon(int w)
	{
		wishes = w;
	}

	public boolean grantWish()
	{
		if(!(hasBeenRecycled))
		{
			wishes--;
			grantedWishes++;
			return true;
		}
		
		return false;
	}

	public String toString()
	{
		if(hasBeenRecycled)
		{
			return "Demon has been recycled.";
		} else
		{
			return "Demon has granted " + grantedWishes + ".";
		}	
	}

}
