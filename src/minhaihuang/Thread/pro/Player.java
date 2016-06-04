package minhaihuang.Thread.pro;
/**
 * 电影屏幕，充当生产者角色
 * @author 黄帅哥
 *
 */
public class Player implements Runnable{

	Movie m;
	
	public Player(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			if(i%2==0){
				m.play("黄海敏");
			}else{
				m.play("lyx");
			}
		}
	}
	
	
}
