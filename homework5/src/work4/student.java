package work4;

import java.io.Serializable;

public class  student  implements Serializable{
	public  String studentID;
	public  String name;
	public String sex;
	public student(String a,String b,String c){
		studentID=a.toString();
		name=b.toString();
		sex=c.toString();
	}
	public student(){}
	public  String getName() {
		return name;
	}
	public  String getStudentID() {
		return studentID;
	}
	public  String getSex() {
		return sex;
	}
}
