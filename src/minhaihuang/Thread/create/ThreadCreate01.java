package minhaihuang.Thread.create;
/**
 * 尝试建立一个多线程：模拟龟兔赛跑
 * 第一种方法：继承Thread类，重写run()方法
 * @author 黄帅哥
 *
 */
public class ThreadCreate01 {

	/**
	 * 通过比较三个线程，我们可以发现程序一会执行线程1，一会执行线程2，一个执行线程3
	 * 具体执行哪个线程取决于cpu的调度
	 * @param args
	 */
	//main方法是主线程
	public static void main(String[] args) {
		//创建Rabbit类的对象，这是线程1
		Rabbit rab=new Rabbit();
		
		//创建乌龟类的对象，这是线程2
		Tortoise tor=new Tortoise();
		
		//调用两个线程类的start()方法，加入到线程组，等待cpu调度。
		rab.start();
		tor.start();
		
		//在main方法里面再次创建打印一个东西.这是线程3
		for(int i=0;i<100;i++){
			System.out.println("main--》"+i);
		}
	}
}

//定义一个兔子类，继承Thread类，重写run()方法，将兔子类写成一个线程类
class Rabbit extends Thread{
	
	//重写run()方法。
	//1，写出run然后Alt+/
	//2，Alt+shift+s，然后选择重写，在方法中，找到run
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("兔子跑了--》"+i+"步");
		}
	}
	
}

//定义一个乌龟类，继承Thread类，重写run()方法，将乌龟类写成一个线程类
class Tortoise extends Thread{
	
	//重写run()方法。
	//1，写出run然后Alt+/
	//2，Alt+shift+s，然后选择重写，在方法中，找到run
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("乌龟跑了--》"+i+"步");
		}
	}
	
}