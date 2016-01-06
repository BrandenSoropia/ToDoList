package todolist;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TodoListTest {
	
	TodoList todoList;
	
//	/* Create num Todo objects that are linked and return head Todo. */
//	Todo makeTodos(int num) {
//		Todo head = new Todo("Task 1", 1, null, null);
//		Todo prevMadeTodo = head;
//		int numMade = 1;
//		while (numMade != num) { // Create num - 1 more Todo objects and link them 
//			numMade++;
//			Todo newTodo = new Todo("Task " + Integer.toString(numMade), numMade, null, prevMadeTodo);
//			prevMadeTodo.setNextTodo(newTodo); 
//			prevMadeTodo = newTodo; // Set prevMadeTodo to the newly made Todo
//		}
//		return head;
//	}
	
	/* Go through TodoList list, and return a list containing each 
	 * Todo object's todoNum in order from head to tail */
	int[] getAllTodoNums(TodoList list) {
		int[] listOfTodoNums = new int[list.getNumTodos()]; // Create an array with size numTodos
		
		int i = 0;
		Todo current = list.getHead();
		while(current != null) {
			listOfTodoNums[i] = current.getTodoNum();
			current = current.getNextTodo();
			i++;
		}
		return listOfTodoNums;
	}
	
	/* Create amt amount of Todo objects and add them to TodoList list.*/
	void addAmountTodo(int amt, TodoList list) {
		Todo head = new Todo("Task 1");
		list.addTodo(head);
		
		int numAdded = 1;
		while(numAdded != amt) {
			numAdded++;
			Todo newTodo = new Todo("Task " + Integer.toString(numAdded));
			list.addTodo(newTodo);
			
		}
	}
	
	/* Return true iff list1 and list 2 have the same head, tail, and numTodos. */
	boolean compareTodoLists(TodoList list1, TodoList list2) {
		if ((list1.getHead() == list2.getHead()) && (list1.getTail() == list2.getTail()) && (list1.getNumTodos() == list2.getNumTodos())) {
			return true;
		}
		return false;
	}
	
	@Before
	public void setUp() {
		this.todoList = new TodoList();
	}

	// Add 1 Todo to list
	@Test 
	public void addOneItem() {
//		TodoList todoList = new TodoList();
		Todo head = new Todo("Task 1");
		this.todoList.addTodo(head);
//		this.todoList.printContents();
		assertEquals("Adding 1 Todo to list.\n", todoList.getHead(), head);
	}
	
	// Add 3 Todo's one after another to list
	@Test
	public void addThreeItems() {
		addAmountTodo(3, this.todoList);
//		this.todoList.printContents();
		assertEquals("Adding 3 Todo's to list.\n", todoList.getNumTodos(), 3);
	}
	
	// Search Empty
	@Test
	public void searchEmpty() {
		assertEquals("Searching empty Todo List.\n", null, this.todoList.findTodo(1));
	}
	
	// Search 1 item list for existing Todo
	@Test 
	public void searchInOneItemListExisting() {
		addAmountTodo(1, this.todoList);
		assertEquals("Searching 1 existing item Todo List.\n", this.todoList.getHead(), this.todoList.findTodo(1));
	}
	
	// Search 1 item list for non-existing Todo
	@Test 
	public void searchInOneItemListNonExisting() {
		addAmountTodo(1, this.todoList);
		assertEquals("Searching 1 non-existing item Todo List.\n", null, this.todoList.findTodo(2));
	}
	
	// Search 3 item list for first task
	@Test
	public void searchInThreeItemListFirstTask() {
		addAmountTodo(3, this.todoList);
		assertEquals("Searching 3 item Todo List for first task.\n", this.todoList.getHead(), this.todoList.findTodo(1));
	}
	
	// Search 3 item list for last task
	@Test
	public void searchInThreeItemListLastTask() {
		addAmountTodo(3, this.todoList);
		assertEquals("Searching 3 item Todo List for last task.\n", this.todoList.getTail(), this.todoList.findTodo(this.todoList.getNumTodos()));
	}
	
	// Decrement starting at head of 3 item list
	@Test
	public void decrementTodoNumFromHeadofThreeItemList() {
		addAmountTodo(3, this.todoList);
		
//		System.out.println("Prior decrement: \n");
//		this.todoList.printContents();
		
		int[] expected = {0, 1, 2};
		this.todoList.decrementTodoNum(this.todoList.getHead());
		
//		System.out.println("After decrement: \n");
//		this.todoList.printContents();
		
		//TODO: Figure out how to test for Decrement Todo num
		assertTrue("Decrement starting at head of 3 item list.\n", Arrays.equals(getAllTodoNums(this.todoList), expected)); 
	}
	
	// Decrement starting in middle of item list
	@Test
	public void decrementTodoNumFromMiddleOfThreeItemList() {
		addAmountTodo(3, this.todoList);
		
//		System.out.println("Prior decrement: \n");
//		this.todoList.printContents();
		
		int[] expected = {1, 1, 2};
		this.todoList.decrementTodoNum(this.todoList.getHead().getNextTodo());
		
//		System.out.println("After decrement: \n");
//		this.todoList.printContents();
		
		assertTrue("Decrement starting at middle of 3 item list.\n", Arrays.equals(getAllTodoNums(this.todoList), expected)); 
	}
	
	// Decrement starting at last item in list
	@Test
	public void decrementTodoNumFromTailOfThreeItemList() {
		addAmountTodo(3, this.todoList);
		
//		System.out.println("Prior decrement: \n");
//		this.todoList.printContents();
		
		int[] expected = {1, 2, 2};
		this.todoList.decrementTodoNum(this.todoList.getTail());
		
//		System.out.println("After decrement: \n");
//		this.todoList.printContents();
		
		//TODO: Figure out how to test for Decrement Todo num
		assertTrue("Decrement starting at middle of 3 item list.\n", Arrays.equals(getAllTodoNums(this.todoList), expected)); 
	}
	
	// Delete on empty list
	@Test
	public void attemptDeleteOnEmptyList() {
		Todo targetTodo = new Todo("This task doesn't exist.");
		// TODO: Consider changing delete function to return something so it can be tested better.
		assertNull("Try to delete on an empty list", this.todoList.deleteTodo(targetTodo));
		
	}
	
	// Delete on 1 item in 1 item list
	@Test
	public void deleteOneItemInOneItemList() {
		addAmountTodo(1, this.todoList);
		this.todoList.deleteTodo(this.todoList.getHead());
		assertTrue("Delete the only item in the list", compareTodoLists(this.todoList, new TodoList(null, null, 0, 0)));
	}
	
	// Delete multiple items one after another, list still contains some items
	@Test
	public void deleteMultipleSequentiallyLeavingSomeItemsInList() {
		addAmountTodo(5, this.todoList);
//		System.out.println("Starting List: \n");
		this.todoList.printContents();

		this.todoList.deleteTodo(this.todoList.findTodo(3)); // Delete middle "Task 3"
		this.todoList.deleteTodo(this.todoList.getTail()); // Delete Tail "Task 5"
		this.todoList.deleteTodo(this.todoList.getHead());// Delete Head "Task 1"
//		System.out.println("Modified List: \n");
//		this.todoList.printContents();
		assertTrue("Delete middle, tail then head in 5 item list.", this.todoList.getHead().getTask().equals("Task 2"));
	}
	
}
