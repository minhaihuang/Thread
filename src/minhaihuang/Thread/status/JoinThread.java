package minhaihuang.Thread.status;
/**
 * 线程的阻塞1：join，先执行完调用join方法的线程
 * @author 黄帅哥
 *
 */
public class JoinThread {

	public static void main(String[] args) throws InterruptedException {
		Test02 demo=new Test02();
		Thread th=new Thread(demo);
		th.start();
		
		//另外一条路径
		for(int i=0;i<1000;i++){
			if(i==50){
				th.join();//这时，main线程阻塞，会一直运行完th这个线程后才运行main线程。但是也不一定
						  //关键取决于CPU的调度
			}	
			System.out.println("main-->"+i);
		}
	}
}

class Test02 implements Runnable{
	
	@Override
	public void run() {
		
			for(int i=0;i<100;i++){
				System.out.println("Thread class-->"+i);
			}
	}
}
