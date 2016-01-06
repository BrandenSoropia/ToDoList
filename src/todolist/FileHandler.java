package todolist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	
	/** Write the Strings contained in listOfStrings to the file.*/
	void writeToFile(FileWriter writer, String[] listOfStrings) throws IOException {
		if (listOfStrings != null) { // Write contents of listOfStrings if not empty
			for(String str : listOfStrings) { // Write each task to file
				writer.write(str + "\n");
			}
		}
	}
	
	/** Writes each incomplete Todo's task in TodoList to text file. */
	void saveTodoList(TodoList listOfIncomplete) throws IOException {
		
		File file = new File("saved_todolist.txt");
		if (file.exists()) { // Delete file if it exists already to get rid of old save state
			if(file.delete()) {
				System.out.println("saved_todolist.txt was deleted.\n" );
			} else {
				System.out.println("Deletion failed.\n" );
			}
		}  
		// Create and open new file under same name
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		// Write contents into file
		writeToFile(writer, listOfIncomplete.getAllTasks());
		System.out.println("Save complete!\n" );
		writer.close();
	}
	
	/** Return a String array containing each line from the given file. */
	String[] readFile(File file) {
		StringBuffer buffer = new StringBuffer();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) { // Collect all lines into a buffer separated by newlines
				buffer.append(line);
				buffer.append("\n");
			}
			bufferedReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return buffer.toString().split("\\r?\\n"); // Split on newline and return String array
		}
	}
	
	/** Return a TodoList created from the contents read from a text file. 
	 * @throws IOException */
	TodoList loadTodoList(String filename) {
		File file = new File(filename);
		if (file.exists()) { // Populate a String array based on file contents
			String[] strings = readFile(file);
			return new TodoList(strings);
			
		} else {
			System.out.println("File does not exist. Created empty TodoList!\n");
			return new TodoList();
		}
		
	}
	
	
/* Below is an attempt for ideal save method */
//	/** Update save text file. */
//	void updateSaveFile(File file) {
//		
//	}
//	
//	/** Write the Strings contained in listOfStrings to the file, and leaving "end" 
//	 * as a section end marker.*/
//	void writeToFile(FileWriter writer, String[] listOfStrings) throws IOException {
//		if (listOfStrings != null) { // Write contents of listOfStrings if not empty
//			for(String str : listOfStrings) { // Write each task to file
//				writer.write(str + "\n");
//			}
//		}
//		
//		writer.write("end\n");
//	}
//
//	/** Writes each Todo's task in TodoList to text file. */
//	void saveTodoList(TodoList listOfIncomplete, TodoList listOfCompleted) throws IOException {
//		File file = new File("saved_todolist.txt"); 
//		if (file.createNewFile()) { // Creates new file if doesn't exist
//			FileWriter writer = new FileWriter(file); 
//			writer.write("NumIncomplete: " + listOfIncomplete.getNumTodos() + "\n");
//			writer.write("NumCompleted: " + listOfIncomplete.getNumCompleted() + "\n\n");
//			
//			writer.write("Incomplete:\n");
//			writeToFile(writer, listOfIncomplete.getAllTasks()); // Write all incomplete tasks to file
//			
//			writer.write("Completed:\n");
//			writeToFile(writer, listOfCompleted.getAllTasks());// Write all completed tasks to file
//		} else { // Append/Update to file
//			// TODO: Figure out how to append/update file. has to recognize all sections
//			// Update numIncomplete and numCompleted
//			// Add
//		}
//	}
	
	/* Used for manual testing. Add static to methods above if used again.*/
//	public static void main(String[] args) { 
//		TodoList list = new TodoList();
////		Todo task1 = new Todo("Task 1"); // Alternate between task 1-3 and 4-6 to see if saved text file changes
////		Todo task2 = new Todo("Task 2");
////		Todo task3 = new Todo("Task 3");
//		Todo task1 = new Todo("Task 4");
//		Todo task2 = new Todo("Task 5");
//		Todo task3 = new Todo("Task 6");
//		list.addTodo(task1);
//		list.addTodo(task2);
//		list.addTodo(task3);
//		try {
//			saveTodoList(list);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		list.printContents();
//	}

	/* Test if readFile (Make readFile static when using this) */
//	public static void main(String[] args) {
//		File file = new File("saved_todolist.txt");
//		String[] strings = readFile(file);
//		for (String str: strings) {
//			System.out.println(str);
//		}
//	}
	
	/* Test if TodoList is generated from text file (Make readFile and loadTodoList static when using this)*/
//	public static void main(String[] args) {
//		TodoList list = loadTodoList("saved_todolist.txt");
//		list.printContents();
//	}
}
