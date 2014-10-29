public class Card
{
	private String name;
	private int image;

	private static int numOfCards = 1;

	public Card(String name)
	{
		this.name = name;
		image = numOfCards++;
	}

	public String getName()
	{
		return name;
	}

	public int getImage()
	{
		return image;
	}

	public void printCard()
	{
		System.out.println("Card " + this.name + " has image " + this.image + ".");
	}	
}
