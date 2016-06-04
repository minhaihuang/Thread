package minhaihuang.Thread.Timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 测试任务调度器
 * 
 * 任务调度器的作用，可以让我们选择使哪个程序在什么时候执行，执行多少次
 * 
 * 在util下
 * @author 黄帅哥
 *
 */
public class TimerTest {

	public static void main(String[] args) {
		Timer time=new Timer();
		
		//指定程序在什么时候执行，每隔多长时间执行一次
		time.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("so easy!!!");
				
			}
			
		}, new Date(), 200);//指定为马上执行，每隔2秒执行一次run()方法
	}
}
