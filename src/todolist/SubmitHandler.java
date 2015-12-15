package todolist;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SubmitHandler implements ActionListener {

	@Override
	/** Prints text from GUI's JTextField then clears it. */
	public void actionPerformed(ActionEvent e) {
		JTextField textField = GUI.getTextFieldComponent();
		System.out.println(textField.getText());
		textField.setText(""); // Clears text from JTextField
	}
	
}
