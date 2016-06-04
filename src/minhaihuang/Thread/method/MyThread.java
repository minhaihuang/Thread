package minhaihuang.Thread.method;
/**
 * 定义一个线程类，方便测试线程的常用方法
 * @author 黄帅哥
 *Thread.currentThread() //获得当前线程
 *
 *getName()//获得线程的名称
 */
public class MyThread implements Runnable{
	
	//1，在线程类中定义线程体使用的标识符
	private boolean flag=true;
	@Override
	public void run() {
		//线程体使用该标识符
		while(flag){
			for(int i=0;i<300;i++){
				System.out.println(Thread.currentThread().getName()+"-->"+i);
			}
		}
	}
	
	//对外提供改变标识符的方法
	public void stop(){
		this.flag=!this.flag;
	}
}
