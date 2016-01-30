import java.util.Collections;
import java.util.Comparator;

public class Lru extends AllocationAlgorithm {

	@Override
	public void replace(int index) {
		
		// verificar se ja esta na memoria
	    boolean notFound = true;
	
	    for (int j = 0; j < memory.size(); ++j) {
	        if (memory.get(j) == null) {
	        	notFound = true;
	        	break;
	        }
	        
	        if (memory.get(j).getId() == pagesQueue.get(index).getId()) {  // ja ta na memoria
	    		memory.get(j).resetPriority();
	    		updatePriority();
	            notFound = false;
	            break;
	        }		        
        }
        
        if (notFound) {
            ++pageFaults;
            
            boolean notAdded = true;
            
            // da pra adicionar direto
            for (int k = 0; k < memory.size(); ++k) {
            	if (memory.get(k) == null) {
            		memory.set(k, pagesQueue.get(index));
            		updatePriority();
            		notAdded = false;
            		break;
            	}
            }
            
            if (notAdded) { // precisa substituir

    			Collections.sort(memory, new Comparator<Page>() {
    				public int compare(Page p1, Page p2) {
    					if (p1.getPriority() > p2.getPriority()) return -1;
    					if (p1.getPriority() < p2.getPriority()) return 1;
    					return 0;
    				}
    			});
    			
    			memory.set(0, pagesQueue.get(index)); // adiciona no começo
    			updatePriority();
            }
        }
	}
	
	private void updatePriority() {
    	for (int k = 0; k < memory.size(); ++k) {
			if (memory.get(k) != null) {
				memory.get(k).increasePriority();
			}
		}
	}
}
