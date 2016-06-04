package minhaihuang.Thread.pro;
/**
 * 理解生产者与消费者模式（线程之间的通信）
 * 
 * 信号灯法。
 * 1，生产者生产时，消费者等待，消费者消费时，生产者等待。
 * 
 * 2，生产完成后，通知消费者消费。消费者消费完后，通知生产者生产。
 * 生产者；播电影
 * 消费者：看电影 
 * 
	3，需要用到Object类的几个方法
	1）wait()，阻塞当前线程，与sleep()不同，wait()会释放锁，释放资源
	
	2)notify()，唤醒在此对象监视器上等待的单个线程。
	
	3)notifyAll();唤醒在此对象监视器上等待的所有线程。
 * @author 黄帅哥
 *
 */
public class Movie{
	String str;

	Movie m;
	//加入信号。
	private boolean flag=true;
	//flag为true时，生产者生产，消费者等待。
	//flag为false时，生产者等待，消费者消费。
	
	//生产的方法，电影屏幕,加入同步
	public synchronized void play(String str){
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.str=str;
		try {
			Thread.sleep(200);
			System.out.println("生产了--》"+str);
			
			this.notify();
			this.flag=false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//生产的方法，电影屏幕,加入同步
		public synchronized void watch(){
			if(flag){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(500);
				System.out.println("消费了--》"+str);
				
				this.notify();
				this.flag=true;
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}
}
