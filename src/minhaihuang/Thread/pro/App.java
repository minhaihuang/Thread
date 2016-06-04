package minhaihuang.Thread.pro;
/**
 * 测试消费者生产者模式
 * @author 黄帅哥
 *
 */
public class App {

	public static void main(String[] args) {
		Movie m=new Movie();
		
		//两个线程访问同一份资源
		Player p=new Player(m);
		Watcher w=new Watcher(m);
		
		//t1生产，初始化资源
		Thread t1=new Thread(p);
		
		//t2消费，负责输出，t1和t2执行不同的操作。
		Thread t2=new Thread(w);
		
		t1.start();
		t2.start();
	}
}
