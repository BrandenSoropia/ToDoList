package todolist;

public class Todo {
	private String task;
	private int status; // 1 is completed, 0 is not completed
	private int todoNum; // ID used to identify todo entry
	private Todo nextTodo;
	private Todo prevTodo;
	
	/** Initialize Todo object setting its task field to given String task,
	 * status and todoNum fields to default 0, and nextTodo and PrevTodo to 
	 * default null. */
	public Todo(String task) {
		this.task = task;
		this.status = 0;
		this.todoNum = 0; // Mark unknown
		this.nextTodo = null;
		this.prevTodo = null;
	}
	
	/** Return String task. */
	String getTask() {
		return task;
	}

	/** Set task field to String task. */
	void setTask(String task) {
		this.task = task;
	}

	/** Return int status. */
	int getStatus() {
		return status;
	}
	
	/** Set status to given int status. */
	void setStatus(int status) {
		this.status = status;
	}

	/** Return int todoNum. */
	int getTodoNum() {
		return todoNum;
	}

	/** Set todoNum to given int todoNum. */
	void setTodoNum(int todoNum) {
		this.todoNum = todoNum;
	}

	/** Return Todo nextTodo. */
	Todo getNextTodo() {
		return nextTodo;
	}

	/** Set nextTodo to given Todo nextTodo. */
	void setNextTodo(Todo nextTodo) {
		this.nextTodo = nextTodo;
	}

	/** Return Todo prevTodo. */
	Todo getPrevTodo() {
		return prevTodo;
	}

	/** Set prevTodo to given Todo prevTodo. */
	void setPrevTodo(Todo prevTodo) {
		this.prevTodo = prevTodo;
	}

	/** Changes status to q if 0 and vice versa. */
	private void changeStatus() {
		if (this.status == 0) {
			this.status = 1;
			System.out.println("Changed status from 0 to 1");
		} else {
			this.status = 0;
			System.out.println("Changed status from 1 to 0");
		} 
	}
	
	/** Return true iff this Todo object's todoNum matches given int todoNum. */
	boolean matchingTodoNum(int todoNum) {
		if (this.getTodoNum() == todoNum) {
			return true;
		}
		return false;
	}
	
	
	@Override
	/** Return a string containing this Todo object's task, status, and 
	 * task number ending in a newline. */
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
