
public class Page {

	private long id;
	private int priority;
		
	public Page(long id) {
		this.id = id;
		this.priority = -1;
	}
	
	public Page(long id, int priority) {
		this.id = id;
		this.priority = priority;
	}
	
	public long getId() {
		return id;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void resetPriority() {
		priority = -1;
	}
	
	public void increasePriority() {
		++priority;
	}
}
