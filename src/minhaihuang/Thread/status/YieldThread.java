package minhaihuang.Thread.status;
/**
 * 线程的阻塞2，yield，让出cpu的调度，让其他的线程先执行。但是不一定，关键取决于CPU的调度
 * @author 黄帅哥
 *
 */
public class YieldThread {

	public static void main(String[] args) throws InterruptedException {
		Test02 demo=new Test02();
		Thread th=new Thread(demo);
		th.start();
		
		//另外一条路径
		for(int i=0;i<1000;i++){
			if(i==50){
				Thread.yield();//这时,让出CPU的调度，由于是用在main线程里，所以是让出main线程的调度，用在哪里，哪里让出
						       //执行的顺序关键还是取决于CPU的调度
			}
			
			System.out.println("main-->"+i);
		}
	}
}
