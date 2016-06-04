package minhaihuang.Thread.status;
/**
 *sleep(时间)，使线程在指定的时间休眠。
 *
 *打印1到10，一秒打印一个
 * @author 黄帅哥
 *
 */
public class SleepThread01 {

	public static void main(String[] args) throws InterruptedException {
		for(int i=1;i<=10;i++){
			
			Thread.sleep(1000);//让线程休眠一秒
			
			System.out.println(i);
		}
	}
}
