package ChocolateBoiler;

public class Chocolate_work {
	public static void work() {
		Thread[] job=new Thread[4];
		for(int i=0;i<4;i++){
			job[i]=new Thread(new Chocolate(i));
			job[i].start();
		}
	}

}
