import java.util.LinkedList;
import java.util.List;

public abstract class AllocationAlgorithm {

	protected List<Page> pagesQueue;
	protected LinkedList<Page> memory;

	protected int numberOfFrames;
	protected int pageFaults;
	
	private final double memoryAccessTime = 200;
	private final double replaceTime = 2000000;	
	
	public void setNumberOfFrames(int n) {
		numberOfFrames = n;
	}
	
	public void setPages(Pages pages) {
		pagesQueue = pages.getList();
		memory = new LinkedList<>();
		
		for (int i = 0; i < numberOfFrames; ++i) {
			memory.add(null);
		}
	}
	
	public void execute() {
		
        for (int k = 0; k < numberOfFrames; ++k) {
    		System.out.print("_ ");
        }
        
        System.out.println();

		for (int i = 0; i < pagesQueue.size(); ++i) {
			replace(i);

            for (int k = 0; k < numberOfFrames; ++k) {
        		if (memory.get(k) == null) {
            		System.out.print("_ ");
        		} else {
        		    System.out.print(memory.get(k).getId() + " ");
        		}
            }
            
            System.out.println();
		}

		
        System.out.println();
        
		System.out.println("Quantidade de page faults: " + pageFaults);
		
		double p = (double)pageFaults / (double)pagesQueue.size();
		System.out.printf("Porcentagem de page faults: %.4f %%\n", (p * 100d));

        System.out.println();
        
		double memoryAccessTotalTime = (pagesQueue.size() - pageFaults) * memoryAccessTime;
		double replaceTotalTime = pageFaults * replaceTime;
		double totalTime = memoryAccessTotalTime + replaceTotalTime;
		System.out.printf("Tempo total gasto: %.4f milissegundos\n", (totalTime / 1000000d));
		System.out.printf("Porcentagem troca: %.4f %%\n", (replaceTotalTime * 100 / totalTime));
		System.out.printf("Porcetagem de acesso: %.4f %%\n", (memoryAccessTotalTime * 100 / totalTime));

        System.out.println();
        
		double EAT = (1 - p) * memoryAccessTime + p * replaceTime;  // EAT = (1 - p) * ma + p * PFtime
		System.out.printf("EAT: %.4f milissegundos\n" , (EAT / 1000000d));
	}
	
	protected abstract void replace(int index);
}
