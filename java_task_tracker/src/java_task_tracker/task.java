package java_task_tracker;

import java.time.LocalDate;

public class task {
	private int id;
	private String name;
	private String description;
	private LocalDate duedate;
	private boolean isCompleted;
	
	public task(int id, String name, String description, LocalDate duedate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.duedate = duedate;
		this.isCompleted = false;
	}
	
	public int getid() {
		return id;
	}
	public String getname() {
		return name;
	}
	public String getdescription() {
		return description;
	}
	public LocalDate duedate() {
		return duedate;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public void setduedate(LocalDate duedate) {
		this.duedate = duedate;
	}
	public void markcompleted() {
		this.isCompleted = true;
	}
	
	//override
	public String toString() {
		return String.format("ID: %d | %s | DUE: %s | %s\n Description: %s ", id, name, duedate, (isCompleted ? " DONE" : " PENDING "), description);
	}

}
