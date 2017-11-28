import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import FCFS.*;
import SJF.SJF;
import TaskWorking.*;



public class work {

	public static void main(String[] args) throws IOException {
		
	//读写文件
//		gg.makeTask();
		gg.readtask();
		
   //执行不同解决方案
   
		int N=2;     //执行队列数
		FCFS fcfs=new FCFS();
		fcfs.NList_working(N);
		SJF sjf=new SJF();
		sjf.NList_working(N);
	}
				

}
