
public class work1 {
	public static void main(String[] arge)
	{
		year y=new year();
		System.out.println("No.1 find year :");
		y.display();
		
		score sc=new score();
		int[] s={0,5,59,60,6,98,74,81};
		sc.input(s);
		System.out.println("\n\nNo.2 ToGradeScore :");
		sc.ToGradeScore();
		
		picture p=new picture();
		System.out.println("\n\nNo.3 print picture :");
		p.display();
		
		flower f=new flower();
		System.out.println("\n\nNo.4 flower number :");
		f.display();
		
	}
}
