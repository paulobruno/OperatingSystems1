
public class Main {

	public static void main(String[] args) {
		// TODO: verificar args[n] no terminal
		// TODO: verificar entrada valida
		Tasks taskList = new Tasks(args[0]);

		Factory factory = new Factory();
		
		// TODO: argumentos adicionais
		ScheduleAlgorithm algorithm = factory.createAlgorithm(args[1]);
		
		AlgorithmStatistics statistics = algorithm.execute(taskList);
		
		statistics.generateFile();
	}
}
