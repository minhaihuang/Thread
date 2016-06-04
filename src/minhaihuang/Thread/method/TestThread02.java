package minhaihuang.Thread.method;
/**
 * 研究多线程的优先级问题
 * 
 * 优先级：Thread.MIN_PRIORITY 优先级最大 10
 * 		 Thread.MAX_PRIORITY 优先级最小 1
 * 		 Thread.NORM_PRIORITY 默认优先级 5
 * 注意：优先级不是绝对的执行顺序，优先级大的只是表名发生的效率高而已
 * @author 黄帅哥
 *
 */
public class TestThread02 {

	public static void main(String[] args) throws InterruptedException {
	
	//创建一个线程
	MyThread demo=new MyThread();
	Thread t1=new Thread(demo,"hhm");
	
	//再创建一个线程
	MyThread demo2=new MyThread();
	Thread t2=new Thread(demo2,"lyx");
	
	//设置两个线程的优先级
	t1.setPriority(Thread.MIN_PRIORITY);//将黄海敏的优先级设置为最小
	t2.setPriority(Thread.MAX_PRIORITY);//将黎泳希的优先级设为最大，黎泳希发生的概率比黄海敏的高

	t1.start();
	t2.start();
	
	Thread.sleep(2);
	
	demo.stop();
	demo2.stop();
	}
}
