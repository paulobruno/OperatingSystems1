public class Optimal extends AllocationAlgorithm {

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
            		notAdded = false;
            		break;
            	}
            }
            
            if (notAdded) { // precisa substituir
            	int pagesChecked = 0;
            	
            	for (int k = index+1; k < pagesQueue.size(); ++k) {
            		if (pagesChecked == memory.size() -1 ) {
            			break;
            		}
            		
        			for (int m = 0; m < memory.size(); ++m) {
        				if (pagesQueue.get(k).getId() == memory.get(m).getId()) {
        					++pagesChecked;
        					Page p = memory.get(m);
        					memory.remove(m);
        					memory.addFirst(p);
        					break;
        				}
        			}
            	}
            	
            	memory.removeLast();
            	memory.add(pagesQueue.get(index));
            }
        }
	}
}
