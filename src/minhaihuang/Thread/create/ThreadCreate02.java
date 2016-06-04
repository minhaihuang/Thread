package minhaihuang.Thread.create;
/**
 * 推荐使用Runnable接口创建线程
 * 
 * 使用Runnable接口+重写run()方法来创建线程，
 * 好处：1，避免单继承的局限性。2，便于共享资源
 * 
 * 步骤：使用静态代理模式
 * 1，创建真实对象
 * 2，创建代理角色Thread+真实角色的引用
 * 3，代理角色.start()来启动线程
 * @author 黄帅哥
 *
 */
public class ThreadCreate02 {

	public static void main(String[] args) {
//		 1，创建真实对象
//		 2，创建代理角色Thread+真实角色的引用
//		 3，代理角色.start()来启动线程
		Test test=new Test();
		Thread th=new Thread(test);
		th.start();
		
		for(int i=0;i<100;i++){
			System.out.println("一边玩酷跑。。。。");
		}
		
	}
}

//使用Runnable接口+重写run()方法来创建一个线程类
class Test implements Runnable{

	@Override
	public void run() {
		
		for(int i=0;i<100;i++){
			System.out.println("一边敲代码。。。。");
		}
	}
	
}