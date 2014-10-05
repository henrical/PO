//package arabiannights;

public class ArabianNights
{
	public static void main(String args[])
	{
		MagicLamp m = new MagicLamp(4);
		
		MagicalEntity e1 = m.rub(2);
		MagicalEntity e2 = m.rub(3);
		MagicalEntity e3 = m.rub(4);
		MagicalEntity e4 = m.rub(5);
		MagicalEntity e5 = m.rub(1);

		System.out.println(e1.toString());	
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		System.out.println(e4.toString());
		System.out.println(e5.toString());	


	}
}
