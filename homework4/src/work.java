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
		
	//��д�ļ�
//		gg.makeTask();
		gg.readtask();
		
   //ִ�в�ͬ�������
   
		int N=2;     //ִ�ж�����
		FCFS fcfs=new FCFS();
		fcfs.NList_working(N);
		SJF sjf=new SJF();
		sjf.NList_working(N);
	}
				

}
