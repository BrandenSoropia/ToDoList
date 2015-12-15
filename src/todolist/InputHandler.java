package todolist;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InputHandler implements ActionListener {

	@Override
	/** Prints text from given ActionEvent source JTextField then clears it. */
	public void actionPerformed(ActionEvent e) {
		JTextField source = (JTextField) e.getSource(); // Get TextField source of event
		System.out.println(source.getText());
		source.setText(""); // Clears text from JTextField
	}
	

}
