package arabiannights;

public class GrumpyGenie extends MagicalEntity
{
	public GrumpyGenie(int w)
	{
		wishes = w;
	}

	public int getGrantedWishes()
	{
		if(grantedWishes>=1)
		{
			return 1;
		}
		
		return 0;
	}

	public boolean grantWish()
	{
		if(getGrantedWishes()==0)
		{
			this.wishes--;
			this.grantedWishes++;
			return true;
		}
	
		return false;
	}

	public String toString()
	{
		if(getGrantedWishes()==1)
		{
			return "Grumpy Genie has granted a wish.";
		} else
		{
			return "Grumpy Genie has a wish to grant.";
		}	
	}
}
