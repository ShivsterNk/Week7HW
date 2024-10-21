import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserRegs {

	public static void main(String[] args) {
		
		//create frame
		JFrame userForm = new JFrame("User Registration");
		userForm.setSize(500, 300);
		userForm.setLayout(new BorderLayout());
		
		JPanel formPanel = new JPanel(new GridLayout(4,2));
		
		//make labels
		JLabel nameLab = new JLabel("Name: ");
		JLabel emailLab = new JLabel("Email: ");
		JLabel passLab = new JLabel("Password: ");
		JLabel confLab = new JLabel("Confirm Password: ");
		
		//text fields
		JTextField nameField = new JTextField(20);
		JTextField emailField = new JTextField(20);
		JTextField passwordField = new JTextField(20);
		JTextField confirmField = new JTextField(20);
		
		//add labels, text fields, and buttons to the form
        formPanel.add(nameLab);
        formPanel.add(nameField);
        formPanel.add(emailLab);
        formPanel.add(emailField);
        formPanel.add(passLab);
        formPanel.add(passwordField);
        formPanel.add(confLab);
        formPanel.add(confirmField);
        
        //make buttons
      	Button submitForm = new Button("Submit");
      	Button clearForm = new Button("Clear");
      	Button exit = new Button("X");
      	
      	//add colors to buttons
      	submitForm.setBackground(Color.GREEN);
      	clearForm.setBackground(Color.RED);
      	exit.setBackground(Color.YELLOW);
      	
      	// when the user submits the form of all fields
      	submitForm.addActionListener(new ActionListener() {
      		
      		public void actionPerformed(ActionEvent e) {
      			String nameInfo = nameField.getText();
      			String emailInfo = emailField.getText();
      			String passInfo = passwordField.getText();
      			String confInfo = confirmField.getText();
      			 
      			if (nameField.getText().isEmpty() || emailField.getText().isEmpty()
      					|| passwordField.getText().isEmpty() || confirmField.getText().isEmpty()) {
      				
      				JOptionPane.showMessageDialog(userForm, "Please fill out the form.");
      			
      			}
      			
      			else if (!passInfo.equals(confInfo)) {
	      			JOptionPane.showMessageDialog(userForm, "Password does not match!");
	      			nameField.setText("");
	                emailField.setText("");
	                passwordField.setText("");
	                confirmField.setText("");
	      			
      			}
      			
      			else {
		      		JOptionPane.showMessageDialog(userForm, 
		      		"Name: " + nameInfo + "\n" + 
		      		"Email: " + emailInfo + "\n" +
		      		"Password: " + passInfo + "\n" +
		      		"Confirmed Password: " + confInfo);
      			}
      			
      		}
      		
      	});
		
		// Add action listener to the clear button
        clearForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
                confirmField.setText("");
            }
        });
        
        // Create separate layout for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        buttonPanel.add(submitForm);
		buttonPanel.add(clearForm);
		
		userForm.add(formPanel, BorderLayout.CENTER);
        userForm.add(buttonPanel, BorderLayout.SOUTH);
		
		
		// Create separate layout for exit button
		JPanel exitPanel = new JPanel(new FlowLayout());
		exitPanel.add(exit);
        userForm.add(exitPanel, BorderLayout.EAST);
        
        exit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	System.out.println("Exiting...");
        	System.exit(0); // Close the frame
        	}
        }); 
		
		 // Add window listener to close the window when user clicks the close button
        userForm.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent we) {
        	System.exit(0);
        	}
        });
        
		// sets form visibility
		userForm.setVisible(true);
		
	}

}
