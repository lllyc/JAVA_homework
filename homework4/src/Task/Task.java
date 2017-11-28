package Task;


public class Task {
	private  int taskID; //����ID
	private  int arrivalTime; //����ʱ��
	private  int serviceTime; //����ʱ��
	private  int startingTime; //��ʼʱ��
	private static int finishingTime; //���ʱ��=��ʼʱ��+����ʱ��
	private static int turnAroundTime; //��תʱ��=���ʱ��-�ﵽʱ��
	private static int weightTurnAround; //��Ȩ��תʱ��=��תʱ��/����ʱ��
	
	public Task(){};
	public Task(int a,int b,int c){
		taskID=a;
		arrivalTime=b;
		serviceTime=c;
	}
	public void setServiceTime(int a){
		startingTime=a;	
	}
	public  void setFinishingTime(){
		finishingTime=startingTime+serviceTime;
	}
	public  void setTurnAroundTime(){
		turnAroundTime=finishingTime-arrivalTime;
	}
	public  void setWeightTurnAround(){
		weightTurnAround=turnAroundTime/serviceTime;
	}
	public  int getTaskID(){
		return taskID;
	}
	public  int getArrivalTime() {
		return arrivalTime;
	}
	public  int getServiceTime() {
		return serviceTime;
	}
	public int getStartingTime() {
		return startingTime;
	}
	public  int getFinishingTime() {
		return finishingTime;
	}
	public int getTurnAroundTime() {
		return turnAroundTime;
	}
	public int getWeightTurnAround() {
		return weightTurnAround;
	}
	
}