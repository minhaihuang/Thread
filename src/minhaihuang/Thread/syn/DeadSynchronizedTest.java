package minhaihuang.Thread.syn;
/**
 * 测试死锁；
 * 死锁的原因：过多的同步；
 * 
 * 例子说明：一手给钱，一手给货，不给我钱，不给你货，不给我货，不给你钱。
 * @author 黄帅哥
 *
 */
public class DeadSynchronizedTest {

	public static void main(String[] args) {
		//先提供一份资源（由一份钱，一份货组成），初始化两个类的数据，使两个类都访问同一份资源。
		Object money=10;
		Object goods="汉堡";
		
		Goods g=new Goods(goods, money);
		Money m=new Money(goods, money);
		
		Thread t1=new Thread(g);
		Thread t2=new Thread(m);
		
		t1.start();
		t2.start();
		//出现了死锁，因为不知道先执行谁
	}
}


//货物类
class Goods implements Runnable{

	//两个对象的初始化由外部初始化
	Object goods;
	Object money;
	
	public Goods(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}

	@Override
	public void run() {
		test();
	}
	
	private void test(){
		
		synchronized(money){//先给钱再到里面拿货
			
			try {
				Thread.sleep(500);//先稍等片刻,实则为放大错误发生的机率
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized(goods){//提货
				
			}
			
		}
	}
	
}

//钱类
class Money implements Runnable{

	//两个对象的初始化由外部初始化
	 Object goods;
	 Object money;
	
	public Money(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}

	@Override
	public void run() {
		test();
	}
	
	private void test(){
		
		synchronized(goods){//先给货再给你钱
			
			try {
				Thread.sleep(500);//先稍等片刻,实则为放大错误发生的机率
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized(money){//给你钱
				
			}
			
		}
	}
	
}
