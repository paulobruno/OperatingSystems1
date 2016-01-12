import java.util.Collections;
import java.util.Comparator;

public class Sjf extends ScheduleAlgorithm {

	@Override
	public void getNextTask() {
		if ((currentTask == null) && (!readyQueue.isEmpty())) {
			
			Collections.sort(readyQueue, new Comparator<Task>() {
				public int compare(Task t1, Task t2) {
					if (t1.getBurstTime() < t2.getBurstTime()) return -1;
					if (t1.getBurstTime() > t2.getBurstTime()) return 1;
					return 0;
				}
			});
			
			/* DEBUG: debug do conteudo da fila de ready
			for (int j = 0; j < readyQueue.size(); ++j) {
				System.out.println("elemento[" + j + "]: " + readyQueue.get(j).getId() + "  p: " + readyQueue.get(j).getPriority() + "  b: " + readyQueue.get(j).getBurstTime());
			}*/
			
			currentTask = readyQueue.get(0);
		}
	}
}
