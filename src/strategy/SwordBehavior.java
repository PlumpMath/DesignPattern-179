package strategy;

public class SwordBehavior implements WeaponBehavior {

	@Override
	public void useWepon() {
		// ʹ�ù������
		System.out.println(getClass().getSimpleName());
	}

}
