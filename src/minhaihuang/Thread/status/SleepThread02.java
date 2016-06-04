package minhaihuang.Thread.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 模拟倒计时，倒数十秒，
 * @author 黄帅哥
 *
 */
public class SleepThread02 {

	public static void main(String[] args) throws InterruptedException {
		//获取当前时间时候，加上10秒钟,作为结束的时间
		long endTime=new Date(System.currentTimeMillis()+10*1000).getTime();
		
		//获得当前时间
		long time=new Date().getTime();
		while(true){
			
			//打印当前的时间
			SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");//只打印分钟和秒数
			System.out.println(sdf.format(endTime));
			
			Thread.sleep(1000);
			endTime=endTime-1000;//结束的时间加去一秒，一秒秒逼近
			if(time>=endTime){
				System.out.println("时间到");
				return;
			}
		}
	}
}
