package minhaihuang.Thread.method;
/**
 * 测试线程中常用的方法
 * @author 黄帅哥
 *
 */
public class TestThread01 {
	public static void main(String[] args) throws InterruptedException {
		MyThread demo=new MyThread();
		Thread t1=new Thread(demo);
		
		System.out.println(Thread.currentThread().getName());//main
		t1.start();
		
		Thread.sleep(2);
		demo.stop();
	}
}
