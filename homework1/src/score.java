import java.util.LinkedList;
import java.util.List;

public class score {
	private static List<Integer> sc=new LinkedList<Integer>();
	
	public static void input(int[] a)
	{
		int i;
		for(i=0;i<a.length;i++)
		{
			if(a[i]>=0 && a[i]<=100)
			{
				sc.add(a[i]);
			}
			else
			{
				System.out.println("your no."+i+" score is error");
			}
		}
	}
	public static void ToGradeScore()
	{
		int i;
		for(i=0;i<sc.size();i++)
		{
			if(sc.get(i)<=59){
				System.out.println("score :"+sc.get(i)+"  grade : ������");
			}
			else{
				if(sc.get(i)<=69){
					System.out.println("score :"+sc.get(i)+"  grade : ����");
				}
				else{
					if(sc.get(i)<=79){
						System.out.println("score :"+sc.get(i)+"  grade : ��");
					}
					else{
						if(sc.get(i)<=89){
							System.out.println("score :"+sc.get(i)+"  grade : ����");
						}
						else{
							if(sc.get(i)<=100){
								System.out.println("score :"+sc.get(i)+"  grade : ����");
							}
							else{
								System.out.println("score :"+sc.get(i)+"  grade : error");
							}
						}
					}
				}
			}
		}
	}
	

}
