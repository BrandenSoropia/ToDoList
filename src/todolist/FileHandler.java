package todolist;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

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
		} else { // Create and open new file under same name
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			// Write contents into file
			writeToFile(writer, listOfIncomplete.getAllTasks());
			writer.close();
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
	
}
