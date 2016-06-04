package minhaihuang.Thread.pro;
/**
 * 观众；充当消费者模式
 * @author 黄帅哥
 *
 */
public class Watcher implements Runnable{
	private Movie m;
	
	public Watcher(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
		m.watch();
		}
	}

	
}
