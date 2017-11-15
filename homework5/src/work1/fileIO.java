package work1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.Scanner;


public class fileIO {
	public static void w1() throws IOException{
		System.out.println("please input :");
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		write("src.txt",s);
		System.out.println("print src.txt finish ");
		s=read("src.txt");
		write("dest.txt",s);
		System.out.println("copy src to dest finish ");
		s=read("dest.txt");
		System.out.println("read dest.txt finish ");
		System.out.println("output :");
		System.out.println(s);
	}
	public static void write(String f,String s) throws IOException{
		File file=new File(f);
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(s);
		bw.flush();
		bw.close();
	}
	public static String read(String f) throws IOException{
		File file=new File(f);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String s="";
		String line="";
		while(line!=null){
			s=s+line;
			line=br.readLine();
		}
		return s;
	}
	
}
