package decorator;

public class Mocha implements Decorator {
	private Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public double cost() {
		return 3.99 + beverage.cost();
	}
}
