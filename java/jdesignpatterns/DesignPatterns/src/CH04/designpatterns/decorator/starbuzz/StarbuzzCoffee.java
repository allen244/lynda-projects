package CH04.designpatterns.decorator.starbuzz;

public class StarbuzzCoffee {
 
	public static void main(String args[]) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() 
				+ " $" + beverage.cost());

		Beverage beverage2 = new HouseBlend();
		beverage2 = new Soy(beverage2);
		beverage2 = new Mocha(beverage2);
		System.out.println(beverage2.getDescription() 
				+ " $" + beverage2.cost());
		
		Beverage decaf = new Decaf();
		decaf = new Milk(decaf);
		decaf = new Whip(decaf);
		
		System.out.println(decaf.getDescription() 
				+ " $" + decaf.cost());
;	}
}
