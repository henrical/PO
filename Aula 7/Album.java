import java.util.*;
import java.lang.Exception;

public class Album
{
	private TreeMap tm;

	public Album()
	{
		tm = new TreeMap<String,Card>();
	}

	@SuppressWarnings("unchecked")
	public void add(Card c)
	{
		tm.put(c.getName(), c);
	}

	public Card get(String name)
	{
		if(!(tm.containsKey(name)))
		{
			throw new RuntimeException();
		}

		return (Card)tm.get(name);	
	}
	
	public boolean containsKey(String name)
	{
		return tm.containsKey(name);
	}	

	public int size()
	{
		return tm.size();
	}
}
