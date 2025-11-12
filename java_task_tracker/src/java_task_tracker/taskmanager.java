package java_task_tracker;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class taskmanager {
	private List<task> tasks=new ArrayList<>();
	private int taskcounter = 1;
	
	//add new task
	public void addtask(Scanner sc) {
		System.out.println("ENTER TASK NAME : ");
		String name = sc.nextLine();
		System.out.println("ENTER TASK DESCRIPTION : ");
		String desc = sc.nextLine();
		System.out.println("ENTER DUE DATE (YYYY-MM-DD) : ");
		try {
			LocalDate due = LocalDate.parse(sc.nextLine());
			tasks.add(new task(taskcounter++, name, desc, due));
			System.out.println("TASK ADDED....!!!!");
		} catch (DateTimeParseException e) {
			System.out.println("INVALID DATE FORMAT!!");
		}
	}
	
	//view all tasks
	public void viewtasks() {
		if(tasks.isEmpty()) {
			System.out.println("NO TASKS AVAILABLE....");
			return;
		}
		for (task t: tasks) {
			System.out.println(t);
		}
	}
	
	//mark a task as done
	public void marktaskdone(Scanner sc) {
		System.out.println("ENTER TASK ID TO MARK AS COMPLETE ");
		int id = sc.nextInt();
		sc.nextLine();
		for (task t : tasks) {
			if(t.getid() == id) {
				t.markcompleted();
				System.out.println("TASK MARKED AS COMPLETED....");
				return;
			}
		}
		System.out.println("TASK NOT FOUND");
	}
	
	//delete task by id
	public void deletetask(Scanner sc) {
		System.out.println("ENTER TASK ID TO DELETE : ");
		int id = sc.nextInt();
		sc.nextLine();
		tasks.removeIf(t -> t.getid() == id);
		System.out.println("IF TASK EXISTED, IT WAS REMOVED.");
		}
	
	//update task details
	public void updatetask(Scanner sc) {
		System.out.println("ENTER TASK ID TO UPDATE : ");
		int id =sc.nextInt();
		sc.nextLine();
		for(task t : tasks) {
			if(t.getid() == id) {
				System.out.println("NEW NAME : ");
				t.setname(sc.nextLine());
				System.out.println("NEW DESCRIPTION : ");
				t.setdescription(sc.nextLine());
				System.out.println("NEW DUE DATE (YYYY-MM-DD) : ");
				try {
					t.setduedate(LocalDate.parse(sc.nextLine()));
				} catch (DateTimeParseException e) {
					System.out.println("INVALID DATE. KEEPING OLD DATE.");
				}
				System.out.println("TASK UPDATED..");
				return;
			}
		}
		System.out.println("TASK NOT FOUND....");
	}

}
