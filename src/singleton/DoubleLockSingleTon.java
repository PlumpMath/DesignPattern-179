package singleton;

/**
 * ���������棬����˫����������
 * 
 * �� 1.4 ������汾�� Java �У���� JVM ���� volatile �ؼ��ֵ�ʵ�ֻᵼ��˫�ؼ�������ʧЧ��
 * �������ʹ�� Java 5��������ʹ�þɰ�� Java����Ҫʹ�ô˼���ʵ�ֵ���ģʽ��
 *
 */
public class DoubleLockSingleTon {
	private volatile static DoubleLockSingleTon intance;
	
	private DoubleLockSingleTon() {}
	
	public static DoubleLockSingleTon getIntance() {
		if (intance == null) {
			synchronized (DoubleLockSingleTon.class) {
				if (intance == null) {
					intance = new DoubleLockSingleTon();
				}
			}
		}
		
		return intance;
	}
}
