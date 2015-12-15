package todolist;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {

	public static void createGUI() {
		JFrame frame = new JFrame("Todo List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create input area JPanel and give it a text field and submit button
		JPanel inputArea = new JPanel();
		inputArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		inputArea.setLayout(new BoxLayout(inputArea, BoxLayout.PAGE_AXIS));
		addTextField("Input Todo Here", inputArea);
		
		frame.getContentPane().add(inputArea);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void addTextField(String text, Container container) {
		JTextField input = new JTextField(text);
		input.addActionListener(new InputHandler());
		container.add(input);
	}
	
	/* Create a button with given String text anad add it to Container container. */
	public static void addButton(String text, Container container) {
		JButton button = new JButton(text);
		container.add(button);
	}
	
	public static void main(String[] args) {
		createGUI();
	}
}
