import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AlgorithmStatistics {

	private String header;
	private int totalProcessingTime;
	private float cpuUtilizationPercentage;
	private float throughputAverage;
	private float turnaroundAverage;
	private float waitTimeAverage;
	private float responseTimeAverage;
	private float contextSwitchAverage;
	private int numberExecutedProcess;
	private int numberProcessEveryExecuteQueue;

	public void generateFile() {
		// TODO: gerar o arquivo de estatisticas.txt        
        try (PrintWriter out = new PrintWriter("estatisticas.txt")) {
        	out.println(header);
            out.println("Tempo total de processamento: " + totalProcessingTime);
            out.println("Percentual de utilizacao da CPU: " + cpuUtilizationPercentage);
            out.println("Media Throughput: " + throughputAverage);
            out.println("Media Turnaround: " + turnaroundAverage);
            out.println("Media Tempo de espera: " + waitTimeAverage);
            out.println("Media Troca de contexto: " + contextSwitchAverage);
            out.println("Numero de processos executados: " + numberExecutedProcess);
            out.close();
        } catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado.");
			e.printStackTrace();
		}
	}
	
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
	
	public int getTotalProcessingTime() {
		return totalProcessingTime;
	}

	public void setTotalProcessingTime(int totalProcessingTime) {
		this.totalProcessingTime = totalProcessingTime;
	}

	public float getCpuUtilizationPercentage() {
		return cpuUtilizationPercentage;
	}

	public void setCpuUtilizationPercentage(float cpuUtilizationPercentage) {
		this.cpuUtilizationPercentage = cpuUtilizationPercentage;
	}

	public float getThroughputAverage() {
		return throughputAverage;
	}

	public void setThroughputAverage(float throughputAverage) {
		this.throughputAverage = throughputAverage;
	}

	public float getTurnaroundAverage() {
		return turnaroundAverage;
	}

	public void setTurnaroundAverage(float turnaroundAverage) {
		this.turnaroundAverage = turnaroundAverage;
	}

	public float getWaitTimeAverage() {
		return waitTimeAverage;
	}

	public void setWaitTimeAverage(float waitTimeAverage) {
		this.waitTimeAverage = waitTimeAverage;
	}

	public float getResponseTimeAverage() {
		return responseTimeAverage;
	}

	public void setResponseTimeAverage(float responseTimeAverage) {
		this.responseTimeAverage = responseTimeAverage;
	}

	public float getContextSwitchAverage() {
		return contextSwitchAverage;
	}

	public void setContextSwitchAverage(float contextChangeAverage) {
		this.contextSwitchAverage = contextChangeAverage;
	}

	public int getNumberExecutedProcess() {
		return numberExecutedProcess;
	}

	public void setNumberExecutedProcess(int numberExecutedProcess) {
		this.numberExecutedProcess = numberExecutedProcess;
	}

	public int getNumberProcessEveryExecuteQueue() {
		return numberProcessEveryExecuteQueue;
	}

	public void setNumberProcessEveryExecuteQueue(
			int numberProcessEveryExecuteQueue) {
		this.numberProcessEveryExecuteQueue = numberProcessEveryExecuteQueue;
	}
}
