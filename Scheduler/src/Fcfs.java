
public class Fcfs extends ScheduleAlgorithm {
	
	@Override
	public void getNextTask() {
		if ((currentTask == null) && (!readyQueue.isEmpty())) {
			currentTask = readyQueue.get(0);
			responseTimeSum += cpuCounter - currentTask.getArrivalTime();
		}
	}
	
	@Override
	public String getAlgorithmHeader() {
	    return "FCFS";
	}
}
