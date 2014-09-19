import static java.lang.System.out;

public class Main
{
	
	public static void main(String args[])
	{	
		Cat gato = new Cat("Fuckerton");
		gato.run();
		out.println( gato.toString() );
			
		Bird passaro = new Bird();
		passaro.fly();
		out.println( passaro.toString() );

		gato.eat(passaro);
		out.println( gato.toString() );
		out.println( passaro.toString() );
	}	

}
