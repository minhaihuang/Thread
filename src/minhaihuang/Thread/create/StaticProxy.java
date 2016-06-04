package minhaihuang.Thread.create;
/**
 * 理解静态代理模式：
 * 静态代理模式的要求：
 * 1，有一个真实的角色
 * 2，有一个代理的角色
 * 3，两者实现同一个接口
 * @author 黄帅哥
 *
 */
public class StaticProxy {

	public static void main(String[] args) {
		//创建一个我自己的对象
		Me me=new Me();
		
		//创建一个婚外公司的对象，传入我自己的对象
		WeddingCompany wed=new WeddingCompany(me);
		
		wed.marry();
	}
}

//创建一个公用接口
interface Marry{
	public void marry();
}

//创建一个真实的角色，我自己
class Me implements Marry{

	@Override
	public void marry() {
		System.out.println("我和黎泳希结婚了");
	}
}

//创建一个代理角色，婚庆公司
class WeddingCompany implements Marry{
	//婚庆公司里面要有我这个人的对象引用
	private Marry me;
	
	
	public WeddingCompany() {
		super();
	}


	public WeddingCompany(Marry you) {
		this.me = you;
	}


	private void before(){
		System.out.println("买房子，买车，表白");
	}
	
	private void after(){
		System.out.println("生一对娃");
	}
	@Override
	public void marry() {
		before();
		me.marry();
		after();
	}
	
}