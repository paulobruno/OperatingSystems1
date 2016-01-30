import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Pages {

	private List<Page> string;
	
	public List<Page> getList() {
		return string;
	}
	
	public Pages(String pagesFile) throws IOException {
		string = new LinkedList<Page>();
		
		Scanner scanner = new Scanner(new File(pagesFile));
		
		while (scanner.hasNextInt()) {
			int id = scanner.nextInt();
			
			string.add(new Page(id));
		}
		
		scanner.close();
	}
}
