//package arabiannights;

public class FriendlyGenie extends MagicalEntity
{
	public FriendlyGenie(int w)
	{
		wishes = w;
	}


	public boolean grantWish()
	{
		if(this.wishes>0)
		{
			this.wishes--;
			this.grantedWishes++;
			return true;
		}
	
		return false;
	}

	public int getRemainingWishes()
	{
		return wishes;
	}

	public String toString()
	{
		return "Friendly Genie has granted " + grantedWishes + " and still has " + wishes + " to grant.";	
	}

}
