import java.util.LinkedList;
import java.util.List;

public abstract class ScheduleAlgorithm {

	protected List<Task> processQueue;
	protected List<Task> readyQueue;
	protected List<Task> finishedQueue;

	protected int cpuCounter;
	protected int numberOfProcess;
	protected Task currentTask;
	
	public void setTasks(Tasks tasks) {
		processQueue = tasks.getList();
		readyQueue = new LinkedList<Task>();
		finishedQueue = new LinkedList<Task>();
	}
	
	public AlgorithmStatistics execute() {
		AlgorithmStatistics statistics = new AlgorithmStatistics();

		initializeExecution();
		
		while (numberOfProcess > finishedQueue.size()) {
			
			addTasksToReady();			
			getNextTask();
			executeCurrentTask();
									
			++cpuCounter;
		}
		
		return statistics;		
	}
	
	public void initializeExecution() {
		numberOfProcess = processQueue.size();
		cpuCounter = 0;
		currentTask = null;		
	}
	
	public void addTasksToReady() {
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
	
	protected abstract void getNextTask();
	
	protected void executeCurrentTask() {
		if (currentTask != null) {
			currentTask.executeStep();
			System.out.println(cpuCounter + ": executing task " + currentTask.getId() + "... (remaining burst time: " + currentTask.getBurstTime() + ")");
			
			// verifies if task has finished
			if (0 == currentTask.getBurstTime()) {
				finishedQueue.add(currentTask);
				readyQueue.remove(currentTask);
				currentTask = null;
			}
		}
		else {
			System.out.println(cpuCounter + ": nothing to execute...");
		}
	}
}
