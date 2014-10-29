public class Main
{
	public static void main(String[] args)
	{
		Card c1 = new Card("jose");
		Card c2 = new Card("simoes");

		Album a1 = new Album();
		a1.add(c1); 
		
		System.out.println("-> a1 has size " + a1.size() +".");

		a1.add(c2);

		System.out.println("-> a1 has size " + a1.size() +".");

		Card c3 = a1.get("jose");
		c3.printCard();
		
		
	}
}
