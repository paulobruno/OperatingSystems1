
public class Factory {

	public static final String RR = "RR";
	public static final String FCFS = "FCFS";
	public static final String SJF = "SJF";
	public static final String SJFP = "SJFP";
	public static final String PRIORITY = "Priority";
	public static final String PRIORITY_P = "PriorityP";

	public ScheduleAlgorithm createAlgorithm(String algorithmName) {

		if (algorithmName.equals(RR)) {
			return new RoundRobin();
		}
		
		else if (algorithmName.equals(FCFS)) {
			return new Fcfs();
		}

		else if (algorithmName.equals(SJF)) {
			return new Sjf();
		}

		else if (algorithmName.equals(SJFP)) {
			return new SjfPreemptive();
		}

		else if (algorithmName.equals(PRIORITY)) {
			return new Priority();
		}

		else if (algorithmName.equals(PRIORITY_P)) {
			return new PriorityPreemptive();
		}

		throw new IllegalArgumentException("Incorrect algorithm name.");
	}	
}
