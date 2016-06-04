package minhaihuang.Thread.createByCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用Callable接口+重写call()方法来创建线程
 * 优点:1,可以抛出异常声明；2，可以有返回值。ps:前面创建线程的方法都没有这两者
 * 缺点：代码量大大增加
 * 
 * 利用龟兔赛跑的例子来说明。
 * @author 黄帅哥
 *
 */
public class Call {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//通过Executors的newFixedThreadPool(int)来获取一个任务调度器ExecutoService对象，
		//通过任务调度器的submit(类)方法来获取一个Future对象。
		ExecutorService ser=Executors.newFixedThreadPool(2);//2表示创建两个线程的意思
		
		//创建一个Race的对象，传进submit里面
		Race tortoise =new Race("乌龟",1000);
		
		Race rabbit =new Race("兔子",500);
		Future<Integer> fu1=ser.submit(tortoise);
		Future<Integer> fu2=ser.submit(rabbit);
		
			Thread.sleep(2000);//让他们跑两秒，统计两秒后的步数
			tortoise.setFlag(false);
			rabbit.setFlag(false);
			
			int num1 = fu1.get();
			int num2=fu2.get();
			
			System.out.println("乌龟跑了-->"+num1+"步");
			System.out.println("兔子跑了-->"+num2+"步");
			
			ser.shutdownNow();//停止线程
		
	}
}


class Race implements Callable<Integer>{//指明要抛出的异常的类型
	private String name;//名字
	private long time;//时间
	private boolean flag=true;//标识符,一开始默认为true
	private int step;//步数
	
	
	
	public Race() {
	}

	public Race(String name) {
		this.name = name;
	}

	public Race(String name, long time) {
		this.name = name;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public Integer call() throws Exception {
	
		while(flag){
			Thread.sleep(time);
			step++;
		}
		return step;
	}

	
}
