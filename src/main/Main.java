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
		/************* ����ģʽ ****************/
		// ��ʼ����ɫ
		King king = new King();
		Queen queen = new Queen();
		
		// ��ʼ������
		SwordBehavior swordBehavior = new SwordBehavior();
		BowAndArrowBehavior bowAndArrowBehavior = new BowAndArrowBehavior();
		
		// ��������
		king.setWeapon(swordBehavior);
		queen.setWeapon(swordBehavior);
		
		// ��ʼս��
		king.fight();
		queen.fight();
		
		// �������岻�����ǿ׳������ս����ѹ�ƣ����Ǹ�����������Ϊ���Ե����֣�
		queen.setWeapon(bowAndArrowBehavior);
		queen.fight();
		
		// ����ʹ��Զ�������������޷�����ս��������ս�ܡ�
		
		/*************�۲���ģʽ ****************/
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
		// ע��
		currentConditionsDisplay.register(weatherData);
		// ����������Ϣ
		weatherData.setMeasurements(11, 22, 33);
		// ȡ��ע��
		currentConditionsDisplay.unregister(weatherData);
		
		/*************װ����ģʽ ****************/
		// ��������ʵ��
		Beverage beverage = new Espresso();
		// ��ӵ��ϣ�װ�Σ�
		beverage = new Mocha(beverage);
		// �����Ǯ
		System.out.println("Total cost:" + beverage.cost());
		
		/*************����ģʽ ****************/
		// �򵥹���
		Factory factory;
		Sender sender;
		Receiver receiver;
		SimpleFactory simpleFactory = new SimpleFactory();
		sender = simpleFactory.produce("mail");
		sender.send();
		sender = simpleFactory.produce("sms");
		sender.send();
		
		// ��̬������ȱ�㣺����ͨ���̳����ı䴴����������Ϊ
		sender = StaticFactory.produce("mail");
		sender.send();
		sender = StaticFactory.produce("sms");
		sender.send();
		
		// ��������
		factory = new SenderFactory();
		sender = factory.createSender();
		sender.send();
		
		// ���󹤳�
		AbstractFactory abstractFactory = new MailFactory();
		sender = abstractFactory.createSender();
		receiver = abstractFactory.createReceiver();
		sender.send();
		receiver.receive();
		
		/*************����ģʽ ****************/
		// java 1.2 �汾֮ǰ��Ҫ��������ע������������ռ�������������

		String type;
		
		// ����
		type = EagerlySingleTon.getIntance().getClass().getSimpleName();
		System.out.println(type);
		
		// ˫������(�����������汾)
		type = DoubleLockSingleTon.getIntance().getClass().getSimpleName();
		System.out.println(type);
		
		// �ڲ���
		type = InnerClassSingleTon.getIntance().getClass().getSimpleName();
		System.out.println(type);
		
		// ö��
		type = EnumSingleTon.INTANCE.getClass().getSimpleName();
		System.out.println(type);
		
		/*************����ģʽ ****************/
		TableLight tableLight = new TableLight();
		LightOnCommand lightOnCommand = new LightOnCommand(tableLight);
		LightOffCommand lightOffCommand = new LightOffCommand(tableLight);
		Controller controller = new Controller();
		controller.setCommand(lightOnCommand);
		controller.doExecute();
		controller.setCommand(lightOffCommand);
		controller.doExecute();
		
		/*************������ģʽ ****************/
		BlueTurkey blueTurkey = new BlueTurkey();
		Duck turkeyAdapter = new adapter.TurkeyAdapter(blueTurkey);
		turkeyAdapter.quack();
		turkeyAdapter.fly();
		
		/*************���ģʽ ****************/
		RemoteController remoteController = new RemoteController();
		remoteController.watchTV();
		remoteController.closeTV();
	}

}
