package todolist;

public class todo {
	private String task;
	private int status; // 1 is completed, 0 is not completed
	private int taskNum; // ID used to identify todo entry
	private todo nextTodo;
	private todo prevTodo;
	
	public todo(String task, int taskNum, todo next, todo prev) {
		this.task = task;
		this.status = 0;
		this.taskNum = taskNum;
		this.nextTodo = next;
		this.prevTodo = prev;
	}
	
	private String getTask() {
		return this.task;
	}
	
	private void setTask(String task) {
		this.task = task;
	}
	
	@Override
	public String toString() {
		return "Task: " + this.task + "\nStatus: " + this.status + "\nTask Number: " + this.taskNum + "\n";
	}
	
}
