package todolist;

public class TodoList {
	private Todo head;
	private Todo tail;
	private int numTodos;
	private int numCompleted;

	public TodoList() {
		this.head = null;
		this.tail = null;
		this.numTodos = 0;
		this.numCompleted = 0;
	}
	
	public TodoList(Todo head, Todo tail, int numTodos, int numCompleted) {
		this.head = head;
		this.tail = tail;
		this.numTodos = numTodos;
		this.numCompleted = numCompleted;
	}

	Todo getHead() {
		return head;
	}

	void setHead(Todo head) {
		this.head = head;
	}

	Todo getTail() {
		return tail;
	}

	void setTail(Todo tail) {
		this.tail = tail;
	}

	int getNumTodos() {
		return numTodos;
	}

	void setNumTodos(int numTodos) {
		this.numTodos = numTodos;
	}

	int getNumCompleted() {
		return numCompleted;
	}

	void setNumCompleted(int numCompleted) {
		this.numCompleted = numCompleted;
	}
	
	void addTodo(Todo entry) {
		if (this.head == null) { // Check if empty Todo list
			this.head = entry;
		}
		
		this.tail.setNextTodo(entry);
	}
	
	Todo findTodo(int todoNum) throws Exception {
		Todo current = this.head;
		// Go through all todo's in list and compare their todoNum with given todoNum
		while (current != null) {
			if (current.matchingTodoNum(todoNum)) { // Return found Todo if matching num
				return current;
			}
			current = current.getNextTodo();
		}
		return null;
	}
	
	/* Go through list starting at 'start' Todo and decrement each of their todoNum by 1. */
	void decrementTodoNum(Todo start) {
		Todo current = start;
		
		while(current != null) {
			current.setTodoNum(current.getTodoNum() - 1);
			current = current.getNextTodo();
		}
	}
	
	/* Removes the target from the list and updates every Todo's 'todoNum' field after target. */
	void deleteTodo(Todo target) {
		// If target is head, make head's next the new head
		if (target.getPrevTodo() == null) {
			this.head = target.getNextTodo();
			decrementTodoNum(this.head);
		} else { // Otherwise, link target's prev to target's next
			target.getPrevTodo().setNextTodo(target.getNextTodo());
			decrementTodoNum(target.getPrevTodo());
		}
	}
	
	
	/* Go through each Todo and print their task, status, task number. */
	void printContents() {
		Todo current = this.head;
		
		while(current != null) {
			current.toString();
			current = current.getNextTodo();
		}
	}
	
}
