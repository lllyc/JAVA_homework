package Sum;

import java.util.LinkedList;
import java.util.List;


public class sum_work {
	public static int NUM=100;       //�ۼӵ���
	public static int size=25;       //ÿ���̵߳�����
	public static List<Integer> sList=new LinkedList<Integer>();    //�����
	public static Thread[] jT=new Thread[NUM/size+1];
	public static void work() {
		for(int i=0;i<=NUM/size;i++){
			jT[i]=new Thread(new Job(i));
			jT[i].start();
		}
	}
	

}
