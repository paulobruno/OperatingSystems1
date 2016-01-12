
public class Factory {

	public static final String RR = "RR";
	public static final String FCFS = "FCFS";
	public static final String SJF = "SJF";
	public static final String SJFP = "SJFP";
	public static final String PRIORITY = "Priority";
	public static final String PRIORITY_P = "PriorityP";

	public ScheduleAlgorithm createAlgorithm(String[] args) throws IllegalArgumentException {
		
		String algorithmName = args[2];

		if (algorithmName.equals(RR)) {
			try {
				int timeQuantum = Integer.parseInt(args[3]);				
				return new RoundRobin(timeQuantum);
			} catch (ArrayIndexOutOfBoundsException e) { 
				e.printStackTrace();
				System.out.println("Algoritmo RoundRobin necessita de parametro adicional <timeQuantum>. Programa abortado.");
				System.exit(1);
			}
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
