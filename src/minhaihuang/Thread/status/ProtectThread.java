package minhaihuang.Thread.status;

import sun.applet.Main;

/**
 * 守护线程
 * 
 * 我们之前定义的线程都默认为前台线程，通过实现Runnable接口后，我们利用其中的setsetDaemon(boolean flag)
 * 可以将其变为后台线程。
 * 
 * 注意：
 * 1，必须在线程启动前设置。
 * 2，当前台线程结束后，后台线程不管有没有执行完，都会结束。
 * @author 黄帅哥
 *
 */
public class ProtectThread  {
	
	public static void main(String[] args) {
				Test test=new Test();
				
				Thread th=new Thread(test);//默认为前台线程
				
				//必须在启动线程之前将其变为守护线程（后台线程）
				th.setDaemon(true);//将其变为后台线程
				th.start();
				
				//当main线程结束后，不管th有没有执行完，都会结束
				for(int i=0;i<10;i++){
					System.out.println(Thread.currentThread().getName()+"-->"+i);
				}
	}
}


class Test implements Runnable{

	@Override
	public void run() {

		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
	
}