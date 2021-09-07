package application;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.*;
/**
 * This is the controller class for the gui. Handles all the logic behind the gui and checks for errors. 
 * @author Harishkarthik kumaran pillai and Brian Moran
 *
 */
public class SampleController implements Initializable{
	
	StudentList root = new StudentList();
	
	@FXML public TextField first;
	@FXML public TextField last;
	@FXML public TextField credit;
	@FXML public TextField funds;
	@FXML public TextArea canvas;
	@FXML public TextField errors;
	
	@FXML public RadioButton instate;
	@FXML public RadioButton outstate;
	@FXML public RadioButton international;
	
	@FXML public CheckBox fund;
	@FXML public CheckBox tri;
	@FXML public CheckBox exc;
	
	
	/**
	 * Initializes the contents of the checkboxes
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		funds.setDisable(false);
		fund.setDisable(false);
		tri.setDisable(true);
		exc.setDisable(true);
	}
	
	//Interface control
	/**
	 * disables and enables correct checkboxes based student type(for instate)
	 */
	public void handleIn() {
		funds.setDisable(false);
		fund.setDisable(false);
		tri.setDisable(true);
		exc.setDisable(true);
	}
	/**
	 * disables and enables correct checkboxes based student type(for outstate)
	 */
	public void handleOut() {
		tri.setDisable(false);
		funds.setDisable(true);
		fund.setDisable(true);
		exc.setDisable(true);
	}
	/**
	 * disables and enables correct checkboxes based student type(for international)
	 */
	public void handleInt() {
		tri.setDisable(true);
		funds.setDisable(true);
		fund.setDisable(true);
		exc.setDisable(false);
	}
	
	//Handle Buttons
	/**
	 * Adds a student to the student list as long as they full fill the correct requirement. Takes in input from appropriate text fields and updates the appropriate
	 * text area.
	 */
	@FXML
	public void handleAdd() {
		String firstName = first.getText();
		String lastName = last.getText();
		
		try
		{
			int credits = Integer.parseInt(credit.getText());
		}
		catch(NumberFormatException ex)
		{
			errors("entered a character for credits, Must enter a number!!!");
		}
		
		int credits = Integer.valueOf(credit.getText());
		boolean tristate = tri.isPressed();
		boolean exchange = exc.isPressed();
		
		if(instate.isSelected()) 
		{
			
			
			
			int funding = Integer.valueOf(funds.getText());
			if(credits <= 0)
			{
				errors("You can't enter a 0 or negative number for credits");
			}
			else if(funding < 0 )
			{
				errors("You can't enter a negative number for funds");
			}
			else
			{
				Student inputStudent = new Instate(firstName,lastName,credits,funding);
				if(root.contains(inputStudent))
				{
					errors("Student is already in the list!");
				}
				else if(credits < 12)
				{
					
					root.add(inputStudent);
					errors("Student added but will not recieve funds because they are part-time");
				}
				else
				{
					root.add(inputStudent);
					errors("Student Added");
				}
			}
		//	System.out.println("Student added");
			
			
			first.setText("");
			last.setText("");
			credit.setText("");
			funds.setText("");
			fund.setSelected(false);
			canvas.setText(" ");
			
		} else if(outstate.isSelected()) {
			
			if(credits <= 0)
			{
				errors("You can't enter a 0 or negative number for credits");
			}
			else
			{
				Student inputStudent = new Outstate(firstName,lastName,credits,tristate);
				if(root.contains(inputStudent))
				{
					errors("Student is already in the list!");
				}
				else
				{
					
					root.add(inputStudent);
					errors("Student Added");
				}
			}
			
			
			
			//System.out.println("Student added");
			
			first.setText("");
			last.setText("");
			credit.setText("");
			tri.setSelected(false);
			canvas.setText(" ");
			
		}else if(international.isSelected()) {
			
			//System.out.println("Student added");
			if(credits <= 0)
			{
				errors("You can't enter a 0 or negative number for credits");
			}
			else
			{
				Student inputStudent = new International(firstName,lastName,credits,exchange);
				if(root.contains(inputStudent))
				{
					errors("Student is already in the list!");
				}
				else if(credits < 9)
				{
					errors("Student not added!!! Must enroll atleast 9 credit hours!!!");
				}
				else
				{
					root.add(inputStudent);
					errors("Student Added");
				}
				
			}
			first.setText("");
			last.setText("");
			credit.setText("");
			exc.setSelected(false);
			canvas.setText(" ");
		}
	}
	/**
	 * removes specified student from the list. Checks that they are not already in the list and also if the list is empty. 
	 */
	public void handleRemove() {
		String firstName = first.getText();
		String lastName = last.getText();
		
		if(root.isEmpty())
		{
			errors("Cannot remove a student from empty list!!!");
		}
		
		Student removal = new Outstate(firstName,lastName,0,true);
		if(root.remove(removal))
		{
			errors("Student removed");
		}
		else
		{
			errors("Student not in the list!!!");
		}
		
		first.setText("");
		last.setText("");
		credit.setText(" ");
	}
	/**
	 * Updates the errors text field to the appropriate error message 
	 * @param message
	 */
	public void errors(String message)
	{
		
		errors.setText(message);
		
	}
	/**
	 *  Handles the printing of the student list. Checks to see if student list is empty.
	 */
	public void handlePrint() {
		
		
		if(root.isEmpty())
		{
			//errorLabel.setText("Sorry, you can't print an empty list!");
			errors("Sorry, you can't print an empty list!");
		}
		else
		{
			canvas.setText(root.printGUI());
		}
		
	}
	public void handleCmd() {
		//TuitionManager.run();
	}
}