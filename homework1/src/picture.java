
public class picture {
	public static int num;
	picture(){
		num=7;
	}
	public static void display(){
		for(int i=1;i<=num;i++){
			for(int j=0;j<(Math.abs((num+1)/2-i)+1);j++){
				System.out.print(" ");
			}
			for(int j=0;j<((num/2+1-Math.abs((num+1)/2-i))*2-1);j++){
				System.out.print("*");
			}
			System.out.println("\n");
		}
	}
    
}
