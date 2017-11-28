package TaskWorking;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Task.Task;


public abstract class workTask {
	//抽象类，定义不同的方式（FCFS or SJF）
	public abstract  Task findTask(List<Task> l);  
	//寻找进入等待队列的任务
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
    //N个处理队列
    public  void NList_working(int N) throws IOException{
    	System.out.println(N+"-list ");
    	List<Task> alltask=gg.readtask();         //全部任务队列
    	List<Task> waitlist=new LinkedList<Task>();        //已经到达待处理的任务
    	int time=0;                      //当前时间
    	int[] lasttime=new int[N];          //每个队列当前任务剩余时间
        Task[] t=new Task[N];       //当前处理的任务
    	boolean[] b=new boolean[N];            //队列是否为空
    	boolean ls=false;
    	int i;
    	for(;;){                        //初始化
    		for(i=0;i<N;i++){
    			b[i]=true;
    		}
    		ls=true;
    		for (i=0;i<N;i++){
    			if(lasttime[i]>0){
    				ls=false;
    			}
    		}
    		if(alltask.isEmpty() && waitlist.isEmpty() && ls ) break;    //结束条件
    		System.out.println("Time = "+time+"   ");
    		//将到达的服务加入等待队列
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
        				b[i]=false;                      //当前任务队列空
        			}
        		}
    		}
    		time++;           //时间计数器累加
    		for (i=0;i<N;i++){
    			lasttime[i]--;       //每个任务剩余时间减1
    		}
    		for (i=0;i<N;i++){               //输出每个队列当前状态
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
