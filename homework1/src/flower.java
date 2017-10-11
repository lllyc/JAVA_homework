
public class flower {
	public static void display()
	{
		int i;
		for(i=100;i<1000;i++)
		{
			if((Math.pow(i%10, 3)+Math.pow(i/100, 3)+Math.pow(((i%100)/10),3))==i)
			{
				System.out.println(i);
			}
		}
	}

}
