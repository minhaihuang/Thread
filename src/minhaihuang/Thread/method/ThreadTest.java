package minhaihuang.Thread.method;
/**
 * 
 * @author 黄帅哥
 *
 */
public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		Test test=new Test();
		Thread th=new Thread(test);
		th.setDaemon(true);
		th.start();
		
		Thread.sleep(10);
		for(int i=0;i<10;i++){
			System.out.println("main-->"+i);
		}
	}
}

class Test implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<100000;i++){
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
		
	}
	
}