import static java.lang.System.out;

public class Main
{
	
	public static void main(String args[])
	{
		Cat cat = new Cat(13,"fuckerton",(float)19.12);

		out.println("new cats name is " + cat.getCatName() + " and it's age is " + cat.getCatAge() + " .It weighs " + cat.getCatWeight() + " pounds.");	
	}	

}
