package TaskWorking;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Task.Task;


public abstract class workTask {
	//�����࣬���岻ͬ�ķ�ʽ��FCFS or SJF��
	public abstract  Task findTask(List<Task> l);  
	//Ѱ�ҽ���ȴ����е�����
	public Task findwait(List<Task> l,int time){
		int index=0;
		for(int i=0;i<l.size();i++){
			if(l.get(index).getArrivalTime()>l.get(i).getArrivalTime()){
				index=i;				
			}
		}
		if(l.get(index).getArrivalTime()<=time){
			return l.remove(index);
		}
		else 
			return null;
	}
    //N���������
    public  void NList_working(int N) throws IOException{
    	System.out.println(N+"-list ");
    	List<Task> alltask=gg.readtask();         //ȫ���������
    	List<Task> waitlist=new LinkedList<Task>();        //�Ѿ���������������
    	int time=0;                      //��ǰʱ��
    	int[] lasttime=new int[N];          //ÿ�����е�ǰ����ʣ��ʱ��
        Task[] t=new Task[N];       //��ǰ���������
    	boolean[] b=new boolean[N];            //�����Ƿ�Ϊ��
    	boolean ls=false;
    	int i;
    	for(;;){                        //��ʼ��
    		for(i=0;i<N;i++){
    			b[i]=true;
    		}
    		ls=true;
    		for (i=0;i<N;i++){
    			if(lasttime[i]>0){
    				ls=false;
    			}
    		}
    		if(alltask.isEmpty() && waitlist.isEmpty() && ls ) break;    //��������
    		System.out.println("Time = "+time+"   ");
    		//������ķ������ȴ�����
    		if(!alltask.isEmpty()){
    			Task ta=findwait(alltask,time);
        		if(ta!=null){
        			waitlist.add(ta);
        		}
    		}
    		for (i=0;i<N;i++)
    		{
    	    	if(lasttime[i]<=0){
    	    		if(!waitlist.isEmpty()){
    	     			t[i]=findTask(waitlist);
    	    			lasttime[i]=t[i].getServiceTime();
        			}
        			else{
        				b[i]=false;                      //��ǰ������п�
        			}
        		}
    		}
    		time++;           //ʱ��������ۼ�
    		for (i=0;i<N;i++){
    			lasttime[i]--;       //ÿ������ʣ��ʱ���1
    		}
    		for (i=0;i<N;i++){               //���ÿ�����е�ǰ״̬
          		if(b[i]){
        	        System.out.println("  LIST"+(i+1)+":   ID : "+t[i].getTaskID()+" ServiceTime : "+t[i].getServiceTime());
         		}
    		    else{
        			System.out.println("  LIST"+(i+1)+":  wait                             ");
    		    }
    		}
    		System.out.println("");
    	}
    }

}
