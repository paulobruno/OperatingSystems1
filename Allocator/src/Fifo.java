public class Fifo extends AllocationAlgorithm {

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
            
            if (notAdded) { // precisa substituir
        	    memory.removeFirst();
        	    memory.addLast(pagesQueue.get(index));                	
            }
        }
	}
}
