import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Tasks {

	private List<Task> schedule;
	
	public List<Task> getList() {
		return schedule;
	}
	
	public Tasks(String tasksFile) throws IOException {
		schedule = new LinkedList<Task>();
		
		Scanner scanner = new Scanner(new File(tasksFile));
		
		while (scanner.hasNextInt()) {
			int arrivalTime = scanner.nextInt();
			int id = scanner.nextInt();
			int burstTime = scanner.nextInt();
			int priority = scanner.nextInt();
			
			schedule.add(new Task(id, burstTime, arrivalTime, priority));
		}
		
		scanner.close();
	}
}
