package adapter;

public class BlueTurkey implements Turkey {

	@Override
	public void gobble() {
		System.out.println(getClass().getSimpleName() + " gobble");
	}

	@Override
	public void fly() {
		System.out.println(getClass().getSimpleName() + " fly");		
	}

}
