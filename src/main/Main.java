package main;

import observer.CurrentConditionsDisplay;
import observer.WeatherData;
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
	}

}
