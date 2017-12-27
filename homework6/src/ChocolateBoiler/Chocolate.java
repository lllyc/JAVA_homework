package ChocolateBoiler;

public class Chocolate implements Runnable {
	private static  boolean empty=true;
	private static  boolean boiled=false;
	private int jobid;
	
    Chocolate(int id){
		jobid=id;
	}
   //改变empty状态
	private synchronized void empty_change() {
		empty=!empty;
	}
   //改变boiled状态
	private synchronized void boiled_change(){
		boiled=!boiled;
	}

	public void fill(){
		for(;;){
			if(empty){
				System.out.println("Fill in chocolate and milk");
				empty_change();
			}
			else{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	public void boil(){
		for(;;){
			if(!empty && !boiled){
				System.out.println("Boiling finish");
				boiled_change();
			}
			else{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void drain(){
		for(;;){
			if(!empty && boiled){
				System.out.println("draining out ");
				empty_change();
				boiled_change();
			}
			else{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}

	public void print_state(){
		 for(;;){
	        	System.out.println("Empty :"+isEmpty()+"  Boiled :"+isBoiled());
	        	try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      }
	}

	public synchronized boolean isEmpty(){
		return empty;
	}

	public synchronized boolean isBoiled(){
		return boiled;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(jobid==0) fill();
		if(jobid==1) boil();
		if(jobid==2) drain();
		if(jobid==3) print_state();
       
	}

}
