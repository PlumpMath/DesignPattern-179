package main;

import observer.CurrentConditionsDisplay;
import observer.WeatherData;
import strategy.BowAndArrowBehavior;
import strategy.King;
import strategy.Queen;
import strategy.SwordBehavior;

public class Main {

	public static void main(String[] args) {
		/************* 策略模式 ****************/
		// 初始化角色
		King king = new King();
		Queen queen = new Queen();
		
		// 初始化武器
		SwordBehavior swordBehavior = new SwordBehavior();
		BowAndArrowBehavior bowAndArrowBehavior = new BowAndArrowBehavior();
		
		// 设置武器
		king.setWeapon(swordBehavior);
		queen.setWeapon(swordBehavior);
		
		// 开始战斗
		king.fight();
		queen.fight();
		
		// 王后身体不如国王强壮，近身战斗被压制，于是更换武器（此为策略的体现）
		queen.setWeapon(bowAndArrowBehavior);
		queen.fight();
		
		// 王后使用远程武器，国王无法近身战斗，导致战败。
		
		/*************观察者模式 ****************/
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
		// 注册
		currentConditionsDisplay.register(weatherData);
		// 更新气象信息
		weatherData.setMeasurements(11, 22, 33);
		// 取消注册
		currentConditionsDisplay.unregister(weatherData);
	}

}
