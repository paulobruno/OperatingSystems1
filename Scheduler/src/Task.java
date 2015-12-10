
public class Task {

	private long id;
	private int burstTime;
	private int arrivalTime;
	private int priority;
		
	public Task(long id, int burstTime, int arrivalTime, int priority) {
		super();
		this.id = id;
		this.burstTime = burstTime;
		this.arrivalTime = arrivalTime;
		this.priority = priority;
	}

	public long getId() {
		return id;
	}
	
	public int getBurstTime() {
		return burstTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void executeStep() {
		--burstTime;
	}
}
