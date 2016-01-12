import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		if (args.length < 3) {
			System.out.println("Programa requer pelo menos 3 parametros: <nome> <arquivo_entrada> <metodo>");
			throw new IllegalArgumentException();
		}
		
		Tasks taskList = null;
		try {
			taskList = new Tasks(args[1]);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Falha na criacao da lista de processos. Arquivo '" + args[1] + "' invalido. Programa abortado.");
			System.exit(1);			
		}

		Factory factory = new Factory();
		
		ScheduleAlgorithm algorithm = null;
		try {
			algorithm = factory.createAlgorithm(args);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Algoritmo '" + args[2] + "' invalido. Programa abortado.");
			System.exit(1);
		}
		
		algorithm.setTasks(taskList);
		AlgorithmStatistics statistics = algorithm.execute();
		statistics.generateFile();
	}
}
