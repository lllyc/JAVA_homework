package TaskWorking;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Task.Task;


public abstract class workTask {
	//�����࣬���岻ͬ�ķ�ʽ��FCFS or SJF��
	public abstract  Task findTask(List<Task> l);
	//һ���������
	public   void oneList_working() throws IOException{
		System.out.println("one-list ");
		List<Task> alltask=gg.readtask();
		List<Task> waittask=new LinkedList<Task>();
		int time=0;   //��ǰʱ��
		int lasttime=0;   //��ǰ������ʱ��
		//��ǰ���������
		Task t=new Task(); 
        boolean b=true;

		for(;;){
			b=true;
			if(alltask.isEmpty() && waittask.isEmpty() && lasttime==0) break;        //������ҵ��ִ�н���
			System.out.println("Time = "+time+"   ");
			//�������������ȴ�����
			if(!alltask.isEmpty()){
     			if(alltask.get(0).getArrivalTime()<=time){
	     			waittask.add(alltask.remove(0));
     			}
			}
			//��ǰ�������
			if(lasttime==0){
				if(!waittask.isEmpty()){
					t=findTask(waittask);
					lasttime=t.getServiceTime();					
				}
				else{
					b=false;
				}
			}	
			time++;
			lasttime--;	
			if(b){
    			System.out.println("  ID : "+t.getTaskID()+" ServiceTime : "+t.getServiceTime()+" last : "+lasttime);
			}
			else {
				System.out.println("wait");
			}
		}
	}
    //�����������
    public   void twoList_working() throws IOException{
    	System.out.println("two-list ");
    	List<Task> alltask=gg.readtask();
    	List<Task> waitlist=new LinkedList<Task>();
    	int time=0;
    	int lasttime1=0;             //��һ��������л���ʱ��
    	int lasttime2=0;             //�ڶ���������л���ʱ��
    	//��ǰ���������
        Task t1=new Task();          
        Task t2=new Task();
    	boolean b1=true;
    	boolean b2=true;
    	for(;;){
    		b1=true;
    		b2=true;
    		if(alltask.isEmpty() && waitlist.isEmpty() && lasttime1<=0 && lasttime2<=0 ) break;
    		System.out.println("Time = "+time+"   ");
    		//������ķ������ȴ�����
    		if(!alltask.isEmpty()){
        		if(alltask.get(0).getArrivalTime()<=time){
        			waitlist.add(alltask.remove(0));
        		}
    		}
    		//��һ���е�ǰ�������
    		if(lasttime1<=0){
    			if(!waitlist.isEmpty()){
    				t1=findTask(waitlist);
    				lasttime1=t1.getServiceTime();
    				
    			}
    			else{
    				b1=false;
    			}
    		}
    		//�ڶ����е�ǰ�������
    		if(lasttime2<=0){
    			if(!waitlist.isEmpty()){
    				t2=findTask(waitlist);
    				lasttime2=t2.getServiceTime();
    			}
    			else{
    				b2=false;
    			}
    		}
    		time++;
    		lasttime1--;
    		lasttime2--;
    		if(b1){
    	    	System.out.print("  LIST1:   ID : "+t1.getTaskID()+" ServiceTime : "+t1.getServiceTime()+" last : "+lasttime1);
    		}
    		else{
    			System.out.print("  LIST1:  wait                             ");
    		}
    		if(b2){
    	    	System.out.println("             LIST2:   ID : "+t2.getTaskID()+" ServiceTime : "+t2.getServiceTime()+" last : "+lasttime2);
    		}
    		else{
    			System.out.println("             LIST2:  wait");
    		}
    		
    	}
    	
    	
    	
    }

}
