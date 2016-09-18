package singleton;

/**
 * 懒汉升级版，或者双重锁定单例
 * 
 * 在 1.4 及更早版本的 Java 中，许多 JVM 对于 volatile 关键字的实现会导致双重检查加锁的失效。
 * 如果不能使用 Java 5，而必须使用旧版的 Java，则不要使用此技巧实现单件模式。
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
