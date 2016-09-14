package main;

import decorator.Beverage;
import decorator.Espresso;
import decorator.Mocha;
import factory.SenderFactory;
import factory.Sender;
import factory.AbstractFactory;
import factory.Factory;
import factory.MailFactory;
import factory.Receiver;
import factory.SimpleFactory;
import factory.StaticFactory;
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
		
		/*************装饰者模式 ****************/
		// 创建咖啡实例
		Beverage beverage = new Espresso();
		// 添加调料（装饰）
		beverage = new Mocha(beverage);
		// 计算价钱
		System.out.println("Total cost:" + beverage.cost());
		
		/*************工厂模式 ****************/
		// 简单工厂
		Factory factory;
		Sender sender;
		Receiver receiver;
		SimpleFactory simpleFactory = new SimpleFactory();
		sender = simpleFactory.produce("mail");
		sender.send();
		sender = simpleFactory.produce("sms");
		sender.send();
		
		// 静态工厂，缺点：不能通过继承来改变创建方法的行为
		sender = StaticFactory.produce("mail");
		sender.send();
		sender = StaticFactory.produce("sms");
		sender.send();
		
		// 工厂方法
		factory = new SenderFactory();
		sender = factory.createSender();
		sender.send();
		
		// 抽象工厂
		AbstractFactory abstractFactory = new MailFactory();
		sender = abstractFactory.createSender();
		receiver = abstractFactory.createReceiver();
		sender.send();
		receiver.receive();
	}

}
