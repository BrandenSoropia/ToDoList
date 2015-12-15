package todolist;

public class TodoList {
	private Todo head;
	private Todo tail;
	private int numTodos;
	private int numCompleted;

	/** Initialize an empty TodoList setting head and tail to null,
	 *  numTodo and numCompleted to 0. */ 
	public TodoList() {
		this.head = null;
		this.tail = null;
		this.numTodos = 0;
		this.numCompleted = 0;
	}
	
	/** Initialize a TodoList object with given Todo head, Todo tail, int numTodos
	 * and int numCompleted. */ 
	public TodoList(Todo head, Todo tail, int numTodos, int numCompleted) {
		this.head = head;
		this.tail = tail;
		this.numTodos = numTodos;
		this.numCompleted = numCompleted;
	}
	
	/** Return Todo head. */
	Todo getHead() {
		return head;
	}
	
	/** Set head to given Todo head. */
	void setHead(Todo head) {
		this.head = head;
	}

	/** Return Todo tail. */
	Todo getTail() {
		return tail;
	}

	/** Set tail to Todo tail. */
	void setTail(Todo tail) {
		this.tail = tail;
	}

	/** Return int numTodos. */
	int getNumTodos() {
		return numTodos;
	}

	/** Set numTodos to given int numTodos. */
	void setNumTodos(int numTodos) {
		this.numTodos = numTodos;
	}

	/** Return int numCompleted */
	int getNumCompleted() {
		return numCompleted;
	}

	/** Set numCompleted to given int numCompleted. */
	void setNumCompleted(int numCompleted) {
		this.numCompleted = numCompleted;
	}
	
	/** Append given Todo entry to TodoList. */
	void addTodo(Todo entry) {
		if (this.head == null && this.tail == null) { // Check if empty Todo list
			this.head = entry;
			this.head.setTodoNum(1);
			this.tail = entry;
		} else {
			Todo oldTail = this.tail; // Save old tail
			oldTail.setNextTodo(entry); // Add new Todo to tail's next
			this.tail = oldTail.getNextTodo(); // Reset tail to newly added Todo
			this.tail.setPrevTodo(oldTail); // Set new tail's prev to the old tail
			this.tail.setTodoNum(oldTail.getTodoNum() + 1);
		}
		this.setNumTodos(this.getNumTodos() + 1);
	}
	
	/** Return Todo object with matching todoNum field with given int todoNum. 
	 * Otherwise, return null iff not found. */
	Todo findTodo(int todoNum) {
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
	
	/** Go through list starting at 'start' Todo and decrement each of their todoNum by 1. 
	 * Return the first modified Todo object. 
	 */
	Todo decrementTodoNum(Todo start) {
		Todo current = start;
		
		while(current != null) {
			current.setTodoNum(current.getTodoNum() - 1);
			current = current.getNextTodo();
		}
		
		return start;
	}
	
	/** Removes the target from the list and updates every Todo's 
	 * 'todoNum' field after target. Return deleted Todo object. */
	Todo deleteTodo(Todo target) {

		if (this.findTodo(target.getTodoNum()) == null) { // Return null if Todo is not in list
			return null;
		} else if (target.getPrevTodo() == null) { // If target is head, make head's next the new head
			if (this.getHead() == this.getTail()) { // if single item list, set head and tail to null
				this.setTail(null);
				this.setHead(null);
			} else { // Otherwise set new head to be old head's next value and modify todoNum's
				this.head = target.getNextTodo();
				decrementTodoNum(this.head);
			}
		} else { // Otherwise, link target's prev to target's next
			target.getPrevTodo().setNextTodo(target.getNextTodo());
			decrementTodoNum(target.getNextTodo()); // Decrement todoNum starting on target's next value
		}
		this.setNumTodos(this.getNumTodos() - 1);
		return target;
	}
	
	
	/** Go through each Todo and print their task, status, task number. */
	void printContents() {
		Todo current = this.head;
		
		if (this.head == null) {
			System.out.println("The Todo List is Empty\n");
		}
		
		while(current != null) {
			System.out.println(current.toString());
			current = current.getNextTodo();
		}
	}
	
}
