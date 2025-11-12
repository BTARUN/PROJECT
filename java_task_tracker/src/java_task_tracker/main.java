package java_task_tracker;
import java.util.Scanner;
public class main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		taskmanager manager = new taskmanager();
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		
		while(running) {
			System.out.println("\n ---- TASK TRACKER ---- ");
			System.out.println("1. ADD TASK");	
			System.out.println("2. VIEW TASKS");
			System.out.println("3. MARK TASK AS DONE");
			System.out.println("4. UPDATE TASK");
			System.out.println("5. DELETE TASK");
			System.out.println("6. EXIT");
			System.out.println("ENTER YOUR CHOICE : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1 -> manager.addtask(sc);
			case 2 -> manager.viewtasks();
			case 3 -> manager.marktaskdone(sc);
			case 4 -> manager.updatetask(sc);
			case 5 -> manager.deletetask(sc);
			case 6 -> {
				running = false;
				System.out.println("EXITING THE TRACKER....");
			}
			default -> System.out.println("INVALID CHOICE....");
			}
	}
		sc.close();

}
}
