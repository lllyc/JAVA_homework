package work2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class filetree {
	public static List<File> f_dir=new LinkedList<File>();
	public static List<File> f_file=new LinkedList<File>(); 
	public static void w2() throws IOException{
		System.out.println("Input path :");
		Scanner sc=new Scanner(System.in);
		String string=sc.nextLine();
		File file=new File(string);
		openfile(file);
		px();
        write();
        System.out.println("finish ");
	}
	public static void openfile(File file){
		File[] f_ar=file.listFiles();
		int i=0;
        if (f_ar!=null){
    		for(i=0;i<f_ar.length;i++){
    			if(f_ar[i].isDirectory()){
	     			f_dir.add(f_ar[i]);
     				openfile(f_ar[i]);
	     		}
    	   		else {
	    			f_file.add(f_ar[i]);
	     		}
    		}
		}
	}
	public static void write() throws IOException{
		File file=new File("filetree.txt");
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
        int i;
		for(i=0;i<f_dir.size();i++){
			bw.write(f_dir.get(i).getName()+"   "+new Date(f_dir.get(i).lastModified()));
			bw.newLine();
			bw.flush();
			
		}
		for(i=0;i<f_file.size();i++){
			bw.write(f_file.get(i).getName()+"  "+new Date(f_file.get(i).lastModified())+"  "+(float)(f_file.get(i).length())/1000/1024+"K");
			bw.newLine();
			bw.flush();
		}
		bw.close();
		
	}
	public static void px() {
		f_dir.sort(Comparator.comparing(File::getName));
		f_file.sort(Comparator.comparing(File::getName));
	}


}
