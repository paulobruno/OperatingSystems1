


public class Fcfs extends ScheduleAlgorithm {
	
	@Override
	public void getNextTask() {
		if ((currentTask == null) && (!readyQueue.isEmpty())) {
			currentTask = readyQueue.get(0);
		}
	}
}
