package minhaihuang.Thread.status;
/**
 * 测试如何来结束一个线程
 * 
 * 结束线程的情况有两种。
 * 1）线程体顺利执行完毕；、
 * 2）外部干涉强行停止线程（推荐使用自己定义的结束方法）。
 * 
 * 此类注意测试第二种情况
 * @author 黄帅哥
 *
 */
public class EndThread {

	public static void main(String[] args) {
		//使用静态代理模式
		//创建一个真实的角色
		Test01 test=new Test01();//新生状态
		//创建一个代理角色Thread+真实角色的引用
		Thread th=new Thread(test);
		//代理角色调用start()方法，将线程加入到线程组
		th.start();//就绪状态
		
		//这是另外一条路径
		for(int i=0;i<1000;i++){
			//第四步，外部根据条件调用改变标识符的方法。
			if(i==50){
				test.stop();
			}
			System.out.println("main method-->"+i);
		}	
	}
}

/**
 * 创建一个线程类，实现Runnable接口，重写run()方法。
 * @author 黄帅哥
 *
 */
class Test01 implements Runnable{

	//外部干涉结束线程的步骤。
	//1，线程类内定义结束线程体的标识符
	//2，线程体使用该标识符
	//3，对外提供改变标识符的方法
	//4，外部根据实际情况调用该方法即可
	
	//第一步：线程类内定义线程体使用的标识符
	private boolean flag=true;
	@Override
	public void run() {
		//第二步：线程体使用该标识
		//while(flag){
			for(int i=0;i<100;i++){
				System.out.println("Thread class-->"+i);
			}
		//}
	}
	
	//第三步：对外提供改变改标识符的方法
	public void stop(){
		this.flag=false;
	}
}