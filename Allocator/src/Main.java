import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		if (args.length < 4) {
			System.out.println("Programa requer pelo menos 4 parametros: <nome> <arquivo_entrada> <metodo> <numero_frames>");
			throw new IllegalArgumentException();
		}
		
		Pages pageList = null;
		try {
			pageList = new Pages(args[1]);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Falha na criacao da lista de paginas. Arquivo '" + args[1] + "' invalido. Programa abortado.");
			System.exit(1);			
		}

		Factory factory = new Factory();
		
		AllocationAlgorithm algorithm = null;
		try {
			algorithm = factory.createAlgorithm(args);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Algoritmo '" + args[2] + "' invalido. Programa abortado.");
			System.exit(1);
		}
		
		algorithm.setNumberOfFrames(Integer.parseInt(args[3]));
		algorithm.setPages(pageList);
		algorithm.execute();
	}
}
