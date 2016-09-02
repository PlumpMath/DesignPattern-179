package strategy;

public class SwordBehavior implements WeaponBehavior {

	@Override
	public void useWepon() {
		// Ê¹ÓÃ¹­¼ıÉä»÷
		System.out.println(getClass().getSimpleName());
	}

}
