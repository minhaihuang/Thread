package minhaihuang.Thread.create;
/**
 * 模拟网上购票(还不够完善)。
 * 使用Runnable来创建线程，方便共享资源
 * @author 黄帅哥
 *
 */
public class Web12306 implements Runnable{

	//一开始默认有50张票
	private int num=50;
	@Override
	public void run() {
		
		while(true){
			//如果票数小于等于0，跳出循环啦
			if(num<=0){
				break;
			}
			
			//打印谁抢到了那张票
			System.out.println(Thread.currentThread().getName()+"抢到了第"+num--+"张票");
		}
		
	}
	
	public static void main(String[] args) {
		//1,创建真实角色
		Web12306 web=new Web12306();
		
		//2，创建4个代理角色Thread，传入真实角色的引用
		Thread th1=new Thread(web,"hhm");
		Thread th2=new Thread(web,"hhc");
		Thread th3=new Thread(web,"h y");
		Thread th4=new Thread(web,"hzy");
		
		//将全部的代理模式加入线程组
		start(th1,th2,th3,th4);
	}

	//封装加入线程组的方法
	public static void start(Thread...thArr){
		for(Thread th:thArr){
			th.start();
		}
	}
}
