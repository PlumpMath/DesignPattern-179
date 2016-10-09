package main;

import adapter.BlueTurkey;
import adapter.Duck;
import command.Controller;
import command.LightOffCommand;
import command.LightOnCommand;
import command.TableLight;
import decorator.Beverage;
import decorator.Espresso;
import decorator.Mocha;
import facade.RemoteController;
import factory.AbstractFactory;
import factory.Factory;
import factory.MailFactory;
import factory.Receiver;
import factory.Sender;
import factory.SenderFactory;
import factory.SimpleFactory;
import factory.StaticFactory;
import observer.CurrentConditionsDisplay;
import observer.WeatherData;
import singleton.DoubleLockSingleTon;
import singleton.EagerlySingleTon;
import singleton.EnumSingleTon;
import singleton.InnerClassSingleTon;
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
		
		/*************单例模式 ****************/
		// java 1.2 版本之前需要建立单件注册表，以免垃圾收集器将单件回收

		String type;
		
		// 饿汉
		type = EagerlySingleTon.getIntance().getClass().getSimpleName();
		System.out.println(type);
		
		// 双重锁定(懒汉的升级版本)
		type = DoubleLockSingleTon.getIntance().getClass().getSimpleName();
		System.out.println(type);
		
		// 内部类
		type = InnerClassSingleTon.getIntance().getClass().getSimpleName();
		System.out.println(type);
		
		// 枚举
		type = EnumSingleTon.INTANCE.getClass().getSimpleName();
		System.out.println(type);
		
		/*************命令模式 ****************/
		TableLight tableLight = new TableLight();
		LightOnCommand lightOnCommand = new LightOnCommand(tableLight);
		LightOffCommand lightOffCommand = new LightOffCommand(tableLight);
		Controller controller = new Controller();
		controller.setCommand(lightOnCommand);
		controller.doExecute();
		controller.setCommand(lightOffCommand);
		controller.doExecute();
		
		/*************适配器模式 ****************/
		BlueTurkey blueTurkey = new BlueTurkey();
		Duck turkeyAdapter = new adapter.TurkeyAdapter(blueTurkey);
		turkeyAdapter.quack();
		turkeyAdapter.fly();
		
		/*************外观模式 ****************/
		RemoteController remoteController = new RemoteController();
		remoteController.watchTV();
		remoteController.closeTV();
	}

}
