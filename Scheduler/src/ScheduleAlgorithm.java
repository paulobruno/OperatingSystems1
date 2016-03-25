import java.util.LinkedList;
import java.util.List;

public abstract class ScheduleAlgorithm {

	protected List<Task> processQueue;
	protected List<Task> readyQueue;
	protected List<Task> finishedQueue;

	protected int cpuCounter;
	protected int numberOfProcess;
	protected Task currentTask;
	protected int totalProcessTime;
	protected int cpuNotBusy;
    protected int throughputSum;
    protected int turnaroundSum;
    protected int waitTimeSum;
    protected int responseTimeSum;    
    protected int contextSwitch;
    
	
	public void setTasks(Tasks tasks) {
		processQueue = tasks.getList();
		readyQueue = new LinkedList<Task>();
		finishedQueue = new LinkedList<Task>();
		
		cpuNotBusy = 0;
		totalProcessTime = 0;
        throughputSum = 0;
        turnaroundSum = 0;
        waitTimeSum = 0;
        responseTimeSum = 0;
		contextSwitch = 0;		
	}
	
	public AlgorithmStatistics execute() {
		AlgorithmStatistics statistics = new AlgorithmStatistics();

		initializeExecution();
		
		while (numberOfProcess > finishedQueue.size()) {
			
			addTasksToReady();
			waitTimeSum += readyQueue.size() - 1;
			getNextTask();
			executeCurrentTask();
									
			++cpuCounter;
		}
		
		statistics.setHeader(getAlgorithmHeader());		
		statistics.setTotalProcessingTime(totalProcessTime);
		statistics.setCpuUtilizationPercentage((float) (1.0 - ((float)cpuNotBusy / (float)(cpuCounter - 1))));
		statistics.setThroughputAverage((float) (100.0 * (1.0 - ((float)cpuNotBusy / (float)(cpuCounter - 1))))); // considering a cpu clock takes 100 units of time
		statistics.setTurnaroundAverage(turnaroundSum / numberOfProcess);
		statistics.setWaitTimeAverage(waitTimeSum / numberOfProcess);
		statistics.setResponseTimeAverage(responseTimeSum / numberOfProcess);
		statistics.setContextSwitchAverage(contextSwitch / numberOfProcess);
		statistics.setNumberExecutedProcess(numberOfProcess);
			
		return statistics;		
	}
	
	protected abstract void getNextTask();
	
	protected abstract String getAlgorithmHeader();
	
	private void executeCurrentTask() {
		if (currentTask != null) {
			currentTask.executeStep();
			System.out.println(cpuCounter + ": executing task " + currentTask.getId() + "... (remaining burst time: " + currentTask.getBurstTime() + ")");
			
			totalProcessTime += currentTask.getBurstTime();
			
			// verifies if task has finished
			if (0 == currentTask.getBurstTime()) {
				finishedQueue.add(currentTask);
				readyQueue.remove(currentTask);
				turnaroundSum += cpuCounter - currentTask.getArrivalTime();// add the finished task turnaround time
				currentTask = null;
			}
		}
		else {
			System.out.println(cpuCounter + ": nothing to execute...");
			
			++cpuNotBusy;
		}
	}
	
	private void initializeExecution() {
		numberOfProcess = processQueue.size();
		cpuCounter = 0;
		currentTask = null;		
	}
	
	private void addTasksToReady() {
		int i = 0;
		while (i < processQueue.size()) {
			if (processQueue.get(i).getArrivalTime() <= cpuCounter) {
				readyQueue.add(processQueue.get(i));
				processQueue.remove(i);
				--i;
			}
			++i;
		}
	}
}
