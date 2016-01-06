package todolist;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class FileHandlerTest {
	
	TodoList todoList;
	FileHandler filehandler;
	
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

	@Test
	public void writeOneTodo() throws IOException {
		addAmountTodo(1, this.todoList);
		filehandler.saveTodoList(todoList);
	}

}
