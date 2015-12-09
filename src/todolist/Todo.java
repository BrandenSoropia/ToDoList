package todolist;

public class Todo {
	private String task;
	private int status; // 1 is completed, 0 is not completed
	private int taskNum; // ID used to identify todo entry
	private Todo nextTodo;
	private Todo prevTodo;
	
	public Todo(String task, int taskNum, Todo next, Todo prev) {
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
	
	private int getStatus() {
		return this.status;
	}
	
	private void setStatus(int status) {
		this.status = status;
	}
	private int getTaskNum() {
		return this.taskNum;
	}

	private void setTaskNum(int taskNum) {
		this.taskNum = taskNum;
	}

	private Todo getNextTodo() {
		return this.nextTodo;
	}

	private void setNextTodo(Todo nextTodo) {
		this.nextTodo = nextTodo;
	}

	private Todo getPrevTodo() {
		return this.prevTodo;
	}

	private void setPrevTodo(Todo prevTodo) {
		this.prevTodo = prevTodo;
	}
	
	private void changeStatus() {
		if (this.status == 0) {
			this.status = 1;
			System.out.println("Changed status from 0 to 1");
		} else {
			this.status = 0;
			System.out.println("Changed status from 1 to 0");
		} 
	}
	
	@Override
	public String toString() {
		return "Task: " + this.task + "\nStatus: " + this.status + "\nTask Number: " + this.taskNum + "\n";
	}
// small quick test 
//	public static void main(String[] args) {
//		Todo todo1 = new todo("Test todo class.", 0, null, null);
//		Todo todo2 = new todo("Next is set.", 0, null, todo1);
//		todo2.setTaskNum(1);
//		todo1.setNextTodo(todo2);
//		System.out.println(todo1.toString());
//		System.out.println(todo1.getNextTodo().toString());
//		System.out.println("Prev node is " + todo1.getNextTodo().getPrevTodo().toString());
//	}
}
