package todolist;

import static org.junit.Assert.*;

import org.junit.Test;

public class TodoListTest {
	
	TodoList todoList;
	
	/* Create num Todo objects and return head Todo */
	Todo makeTodos(int num) {
		Todo head = new Todo("Task 1", 1, null, null);
		Todo prevMadeTodo = head;
		int numMade = 1;
		while (numMade != num) { // Create num - 1 more Todo objects and link them 
			numMade++;
			Todo newTodo = new Todo("Task " + Integer.toString(numMade), numMade, null, prevMadeTodo);
			prevMadeTodo.setNextTodo(newTodo); 
			prevMadeTodo = newTodo; // Set prevMadeTodo to the newly made Todo
		}
		return head;
	}

	public void setUp() {
		this.todoList = new TodoList();
	}

	// Add 1 Todo to list
	@Test 
	public void addOneItem() {
		Todo head = makeTodos(1);
		this.todoList.addTodo(head);
		assertEquals("Adding 1 Todo to list", "Task 1", "Task 1");
	}
	// Add 3 Todo to list
	
	// Search Empty
	// Search 1 item list
	// Search 3 item list
	
	// Decrement starting at head of 3 item list
	// Decrement starting in middle of item list
	// Decrement starting at last item in list
	
	// Delete on empty list
	// Delete on 1 item in 1 item list
	// Delete multiple items one after another
	
	// Print empty list
	// Print 1 item list
	// Print 3 item list

}
