package minhaihuang.Thread.syn;
/**
 * 提升web12306，加入网络延时，同时使其变为线程安全的
 * @author 黄帅哥
 *
 */
public class ImproveWeb12306 {

	public static void main(String[] args) {
		// 1,创建真实角色
		Web12306 web = new Web12306();

		// 2，创建4个代理角色Thread，传入真实角色的引用
		Thread th1 = new Thread(web, "hhm");
		Thread th2 = new Thread(web, "hhc");
		Thread th3 = new Thread(web, "h y");
		Thread th4 = new Thread(web, "hzy");

		// 将全部的代理模式加入线程组
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}

}

class Web12306 implements Runnable {

	Object obj = new Object();
	static boolean flag = true;

	// 一开始默认有50张票
	private static int num = 50;

	@Override
	public void run() {

		/*while (flag) {
			//在这里进行锁定可使四个代理都执行
			synchronized (obj) {//obj代表的是锁 可以为任意对象
				//synchronized (this) {//this锁定的是当前的对象
				test03();
			}
		}*/
		
		while (flag) {
				test01();
			}

	}

	// 加入synchronized，所定方法，使其每次只有一个代理角色访问进入方法体访问资源
	public static synchronized void test01() {
		// 如果票数小于等于0，跳出循环啦
		if (num <= 0) {
			flag = false;
			return;
		}
		// 加入网络延时,休眠一秒
		try {
			Thread.sleep(100);// 线程等待，有可能发生并发问题
		} catch (InterruptedException e) {
			System.out.println("网络延时这里有错" + e.getMessage());
		}
		// 打印谁抢到了那张票
		System.out.println(Thread.currentThread().getName() + "抢到了第" + num--
				+ "张票");
	}

	//同步方法块，锁定的是this，表示当前对象
	public void test02() {
		// 如果票数小于等于0，跳出循环啦
		synchronized (this) {// 锁定资源，注意锁定的范围
			if (num <= 0) {
				flag = false;
				return;
			}
			// 加入网络延时,休眠一秒
			try {
				Thread.sleep(500);// 线程等待，有可能发生并发问题
			} catch (InterruptedException e) {
				System.out.println("网络延时这里有错" + e.getMessage());
			}
			
			// 打印谁抢到了那张票
			System.out.println(Thread.currentThread().getName() + "抢到了第"
					+ num-- + "张票");
		}
	}

	
	//普通的方法
	public void test03() {

		if (num <= 0) {
			flag = false;
			return;
		}
		// 加入网络延时,休眠一秒
		try {
			Thread.sleep(100);// 线程等待，有可能发生并发问题
		} catch (InterruptedException e) {
			System.out.println("网络延时这里有错" + e.getMessage());
		}
		// 打印谁抢到了那张票
		System.out.println(Thread.currentThread().getName() + "抢到了第" + num--
				+ "张票");
	}

}
