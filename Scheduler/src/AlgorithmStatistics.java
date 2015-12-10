import java.util.List;

public class AlgorithmStatistics {

	private String header;
	private List<String> parameterList;
	private int totalProcessingTime;
	private float throughputAverage;
	private float turnaroundAverage;
	private float waitTimeAverage;
	private float responseTimeAverage;
	private float contextChangeAverage;
	private int numberExecutedProcess;
	private int numberProcessEveryExecuteQueue;

	public void generateFile() {
		// TODO: gerar o aqruivo de estatisticas.txt
	}
	
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<String> getParameterList() {
		return parameterList;
	}

	public void setParameterList(List<String> parameterList) {
		this.parameterList = parameterList;
	}

	public int getTotalProcessingTime() {
		return totalProcessingTime;
	}

	public void setTotalProcessingTime(int totalProcessingTime) {
		this.totalProcessingTime = totalProcessingTime;
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

	public float getContextChangeAverage() {
		return contextChangeAverage;
	}

	public void setContextChangeAverage(float contextChangeAverage) {
		this.contextChangeAverage = contextChangeAverage;
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
