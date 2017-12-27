package Sum;


//累加的runnable

public class Job implements Runnable {
	private int jobID;
	public Job(int j){
		jobID=j;
	}
	//区间内累加
	public int sum(int star,int end){
		int i;
		int s=0;
		for(i=star+1;i<=end;i++){
			s=s+i;
		}
		return s;
	}
	//结果的总和
	public int all_sum(){
		int s=0;
		for(int i=0;i<sum_work.sList.size();i++){
			s=s+sum_work.sList.get(i);
		}
		return s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
        if(jobID==0){
        	for(;;){
        		if(sum_work.sList.size()!=sum_work.NUM/sum_work.size){
        			try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}        		
        		}
        		else{
        			System.out.println("all sum is "+all_sum());
        			break;
        		}
        	}
        }
        else{
        	int s=0;
        	for(;;){
        		if(jobID==sum_work.sList.size()+1){
        			s=sum((jobID-1)*sum_work.size, jobID*sum_work.size);
        			synchronized (this) {
        				System.out.println("no."+jobID+"  the sum "+(jobID-1)*sum_work.size+" to "+jobID*sum_work.size+"   result is "+s);
                        sum_work.sList.add(s);
					}
					break;
				}    
        		else{
        			try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        	}
        }
        
	}

}
