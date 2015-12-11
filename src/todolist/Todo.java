package todolist;

public class Todo {
	private String task;
	private int status; // 1 is completed, 0 is not completed
	private int todoNum; // ID used to identify todo entry
	private Todo nextTodo;
	private Todo prevTodo;
	
	public Todo(String task) {
		this.task = task;
		this.status = 0;
		this.todoNum = 0; // Mark unknown
		this.nextTodo = null;
		this.prevTodo = null;
	}
	
	String getTask() {
		return task;
	}

	void setTask(String task) {
		this.task = task;
	}

	int getStatus() {
		return status;
	}

	void setStatus(int status) {
		this.status = status;
	}

	int getTodoNum() {
		return todoNum;
	}

	void setTodoNum(int todoNum) {
		this.todoNum = todoNum;
	}

	Todo getNextTodo() {
		return nextTodo;
	}

	void setNextTodo(Todo nextTodo) {
		this.nextTodo = nextTodo;
	}

	Todo getPrevTodo() {
		return prevTodo;
	}

	void setPrevTodo(Todo prevTodo) {
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
	
	boolean matchingTodoNum(int todoNum) {
		if (this.getTodoNum() == todoNum) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "Task: " + this.task + "\nStatus: " + this.status + "\nTask Number: " + this.todoNum + "\n";
	}
// small quick test 
//	public static void main(String[] args) {
//		Todo todo1 = new Todo("Test todo class.", 0, null, null);
//		Todo todo2 = new Todo("Next is set.", 0, null, todo1);
//		todo2.setTodoNum(1);
//		todo1.setNextTodo(todo2);
//		System.out.println(todo1.toString());
//		System.out.println(todo1.getNextTodo().toString());
//		System.out.println("Prev node is " + todo1.getNextTodo().getPrevTodo().toString());
//	}
}
