package work4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class student_sort {
	public static List<student> s_List=new LinkedList<student>();
	public static void read(String f) throws IOException{
		File file=new File(f);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line="";
		while(true){
			line=br.readLine();
			if(line==null) break;
	        String[] s=line.split(" ");
	        student stu=new student(s[0],s[1],s[2]);
	        s_List.add(stu);
		}
	}
	public static void px() {
		s_List.sort(Comparator.comparing(student::getStudentID));		
	}
	public static void write_object(String f) throws IOException{
		File file=new File(f);
		FileOutputStream fOutputStream=new FileOutputStream(file);
		ObjectOutputStream p=new ObjectOutputStream(fOutputStream);
		int i;
		p.writeObject(s_List);
		p.close();
	}
	public static void read_object(String f) throws IOException, ClassNotFoundException{
		File file=new File(f);
		FileInputStream fInputStream=new FileInputStream(file);
		ObjectInputStream p=new ObjectInputStream(fInputStream);
        Object ob=p.readObject();
        List<student> sl=(LinkedList<student>)ob;
        for(int i=0;i<sl.size();i++){
        	System.out.println(sl.get(i).getStudentID()+"  "+sl.get(i).getName()+"  "+sl.get(i).getSex());
        }
	}
	public static void w4() throws ClassNotFoundException, IOException  {
		read("list.txt");
		px();
		write_object("student.bin");
		read_object("student.bin");
	}
	
}
