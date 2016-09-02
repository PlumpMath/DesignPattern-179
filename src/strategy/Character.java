package strategy;

public abstract class Character {
	WeaponBehavior weapon;
	
	public void setWeapon(WeaponBehavior weapon) {
		this.weapon = weapon;
	}
	
	public void fight() {
		weapon.useWepon();
	}
}
