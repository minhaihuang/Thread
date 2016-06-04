package minhaihuang.Thread.status;
/**
 * 改进之前写的web12306，加入网络延时，但是依然会发生并发问题。
 * 
 * 并发问题的原因分析：
 * 有4个代理角色 hhm hhc  hzy hy;
 * 当hhm进入到方法体里面时，等待，等待的过程中，其余的三个角色也有可能进入方法体，若
 * 此时的票数只剩下一张，等待的时间一到，hhm将会带走唯一的一张票，而其余的三个角色由于没有票了，但是他们也需要
 * 带走票，所以就会出现带走第0,-1,-2张票的情况，这就是并发问题。为了解决这一问题，需要加入锁(synchronized)的概念
 * 锁的意思是一次只能有一个角色进入方法体，或者方法块，这就保证了数据的安全
 * @author 黄帅哥
 *
 */
public class SleepThread03 {

	public static void main(String[] args) {
		//1,创建真实角色
		Web12306 web=new Web12306();
		
		//2，创建4个代理角色Thread，传入真实角色的引用
		Thread th1=new Thread(web,"hhm");
		Thread th2=new Thread(web,"hhc");
		Thread th3=new Thread(web,"h y");
		Thread th4=new Thread(web,"hzy");
		
		//将全部的代理模式加入线程组
		//Web12306.start(th1,th2,th3,th4);
	}

}

//class Web12306 implements Runnable{
//
//	//一开始默认有50张票
//	private int num=50;
//	@Override
//	public void run() {
//		
//		while(true){
//			//如果票数小于等于0，跳出循环啦
//			if(num<=0){
//				break;
//			}
//			
//			//加入网络延时,休眠一秒
//			try {
//				Thread.sleep(1000);//线程等待，有可能发生并发问题
//			} catch (InterruptedException e) {
//				System.out.println("网络延时这里有错"+e.getMessage());
//			}
//			//打印谁抢到了那张票
//			System.out.println(Thread.currentThread().getName()+"抢到了第"+num--+"张票");
//		}
//		
//	}
//	
//	//封装加入线程组的方法
//	public static void start(Thread...thArr){
//		for(Thread th:thArr){
//			th.start();
//		}
//	}
//}
