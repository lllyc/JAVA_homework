package work3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {
	public static void IOwithBuffer(String f1,String f2) throws IOException{
		File file1=new File(f1);
		FileReader fr=new FileReader(file1);
		BufferedReader br=new BufferedReader(fr);
		String s="";
		String line="";
		while(line!=null){
			s=s+line;
			line=br.readLine();
		}
		File file2=new File(f2);
		FileWriter fw=new FileWriter(file2);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(s);
		bw.flush();
		bw.close();
	}
	public static void IOwithoutBuffer(String f1,String f2) throws IOException{
		File file1=new File(f1);
		FileReader fr=new FileReader(file1);
		char[] c=new char[1024];
		String s="";
		String line="";
		int num=0;
		while((num=fr.read(c))!=-1){
			line=new String(c);
			s=s+line;
		}
		File file2=new File(f2);
		FileWriter fw=new FileWriter(file2);
        fw.write(s);
		fw.flush();
		fw.close();
	}
	public static void w3() throws IOException{
		String f1="IOtest.txt";
		String f2="IOtestcopy.txt";
		long startTime;
		long endTime;
		startTime=System.currentTimeMillis();
		IOwithBuffer(f1, f2);
		endTime=System.currentTimeMillis();
		System.out.println("IO with Buffer use Time :"+(endTime-startTime)+" ms");
		startTime=System.currentTimeMillis();
		IOwithoutBuffer(f1, f2);
		endTime=System.currentTimeMillis();
		System.out.println("IO without Buffer use Time :"+(endTime-startTime)+" ms");
	}
}
