
public class RoundRobin extends ScheduleAlgorithm {

	private int timeQuantum;
	private int currentTaskTime;
	
	public RoundRobin(int timeQuantum) {
		super();
		this.timeQuantum = timeQuantum;
		currentTaskTime = 1;
	}

	@Override
	protected void getNextTask() {
		if (currentTask != null) {
			if (currentTaskTime >= timeQuantum) {
				readyQueue.remove(currentTask);
				readyQueue.add(currentTask);
				currentTask = readyQueue.get(0);
			    responseTimeSum += cpuCounter - currentTask.getArrivalTime();
				currentTaskTime = 1;
			}
			else {
				++currentTaskTime;
			}
		}
		else if ((!readyQueue.isEmpty())) {
			currentTask = readyQueue.get(0);
			responseTimeSum += cpuCounter - currentTask.getArrivalTime();
			currentTaskTime = 1;
		}
	}
	
	@Override
	public String getAlgorithmHeader() {
	    return "Round Robin, time quantum: " + timeQuantum;
	}
}
