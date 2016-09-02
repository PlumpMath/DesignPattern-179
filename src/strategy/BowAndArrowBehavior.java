package strategy;

public class BowAndArrowBehavior implements WeaponBehavior {

	@Override
	public void useWepon() {
		//  π”√¥Û±¶Ω£
		System.out.println(getClass().getSimpleName());
	}

}
