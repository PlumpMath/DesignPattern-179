package strategy;

public class BowAndArrowBehavior implements WeaponBehavior {

	@Override
	public void useWepon() {
		// ʹ�ô󱦽�
		System.out.println(getClass().getSimpleName());
	}

}
