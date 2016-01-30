
public class Factory {

	public static final String FIFO = "FIFO";
	public static final String LRU = "LRU";
	public static final String OPTIMAL = "Optimal";

	public AllocationAlgorithm createAlgorithm(String[] args) throws IllegalArgumentException {
		
		String algorithmName = args[2];

        if (algorithmName.equals(FIFO)) {
			return new Fifo();
		}

		else if (algorithmName.equals(LRU)) {
			return new Lru();
		}

		else if (algorithmName.equals(OPTIMAL)) {
			return new Optimal();
		}

		throw new IllegalArgumentException("Incorrect algorithm name.");
	}	
}
