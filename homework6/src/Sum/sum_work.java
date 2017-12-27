package Sum;

import java.util.LinkedList;
import java.util.List;


public class sum_work {
	public static int NUM=100;       //累加的数
	public static int size=25;       //每个线程的区间
	public static List<Integer> sList=new LinkedList<Integer>();    //结果集
	public static Thread[] jT=new Thread[NUM/size+1];
	public static void work() {
		for(int i=0;i<=NUM/size;i++){
			jT[i]=new Thread(new Job(i));
			jT[i].start();
		}
	}
	

}
