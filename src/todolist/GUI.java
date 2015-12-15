package todolist;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
	private static JTextField input;
	private static TodoList todoList;

	/** Create main JFrame and populate it with button, text field and display area. */
	public static void createGUI() {
		JFrame frame = new JFrame("Todo List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create input area JPanel and give it a text field and submit button
		JPanel inputArea = new JPanel();
		inputArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		inputArea.setLayout(new BoxLayout(inputArea, BoxLayout.PAGE_AXIS));
		addTextField("Input Todo Here and press \"enter\" or \"Submit\"", inputArea, new InputHandler());
		input = (JTextField) inputArea.getComponent(0);
		addButton("Submit", inputArea, new SubmitHandler());
		
		frame.getContentPane().add(inputArea);
		frame.pack();
		frame.setVisible(true);
	}
	
	/** Add TextField to given Container container with given ActionListener action 
	 * and setting it to display String text */
	public static void addTextField(String text, Container container, ActionListener action) {
		JTextField textfield = new JTextField(text, 30);
		textfield.addActionListener(action);
		container.add(textfield);
	}
	
	/** Create a button with given String text anad add it to Container container. */
	public static void addButton(String text, Container container, ActionListener action) {
		JButton button = new JButton(text);
		button.addActionListener(action);
		container.add(button);
	}
	
	/** Get TextField object. */
	public static JTextField getTextFieldComponent() {
		return input;
	}
	
	/** Get TodoList object. */
	public static TodoList getTodoList() {
		return todoList;
	}
	
	public static void main(String[] args) {
		todoList = new TodoList();
		createGUI();
	}
}
