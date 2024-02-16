// @author: Virag Kiss
// @version: 2
// @date: 4/4/2023

import java.util.Scanner;
import java.util.ArrayList;

public class University{
	
	private ArrayList<Enrolment> enrolments;

	public University(){

		this.enrolments = new ArrayList<Enrolment>();
	}

	public University(ArrayList<Enrolment> enrolments){

		this.enrolments = enrolments;
	}

	public void display(){

		//System.out.println(this.enrolments.display());  // call display method of Enrolment class
		for (Enrolment enrolment : this.enrolments){
            System.out.println(enrolment.display()+"\n");
        }
	}

	public void addEnrolment(Enrolment newEnrolment){
		this.enrolments.add(newEnrolment);
	}
	
	// get methods
	public ArrayList<Enrolment> getEnrolments(){

		return this.enrolments;
	}
	public int getEnrolmentSize(){
		return this.enrolments.size();
	}
	public Enrolment getSpecificEnrolment(int index){
		return this.enrolments.get(index);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	// input student and unit details
	public void inputStudentDetails(Enrolment enrolment){

		//Input studentInput = new Input();
		//Validation checkInput = new Validation();
		String name; String address; String phoneNo; String email;
		boolean isInputBlank;
		
		//Input name
		do{
			name = Input.acceptStringInput("Enter student first and last name: ");
			isInputBlank = Validation.isBlank(name);
		} while( isInputBlank );

		//Input address
		do{
			address = Input.acceptStringInput("Enter student address: ");
			isInputBlank = Validation.isBlank(address);
		} while( isInputBlank );

		//Input phone number
		do{
			phoneNo = Input.acceptStringInput("Enter student phone number: ");
			isInputBlank = Validation.isBlank(phoneNo);
		} while( isInputBlank );

		///Input email
		do{
			email = Input.acceptStringInput("Enter student email address: ");
			isInputBlank = Validation.isBlank(email);
		} while( isInputBlank );
		
		// check if details are taken in
		System.out.println("The entered student details are: "+name+", "+address+", "+phoneNo+", "+email);
		
		// create student field in enrolment
		enrolment.createStudent(name, address, phoneNo, email);
		
		// check
		System.out.println("Displaying enrolment after adding student: "+enrolment.display());
		
	}

	public void inputUnitDetails(Enrolment enrolment){
		// call the inputUnitDetailsOnce method every time a student enrols in a unit
		int units = enrolment.getUnitsSize();
		for (int i=0; i < units; i++){
			inputUnitDetailsOnce(i, enrolment);
		}
		System.out.println("Student successfully enrolled in "+units+" units.");
		System.out.println("Displaying enrolment after adding units: "+enrolment.display());
	}

	public void inputUnitDetailsOnce(int index, Enrolment enrolment){

		//Input unitInput = new Input();
		//Validation checkInput = new Validation();

		//Input code
		String code; String description; int points;
		boolean isInputBlank; boolean isInputWithinRange;
		
		do{
			code = Input.acceptStringInput("Enter unit code: ");
			isInputWithinRange = Validation.lengthWithinRange(code, 7, 7);
		} while( !isInputWithinRange );

		//Input description
		do{
			description = Input.acceptStringInput("Enter unit description: ");
			isInputBlank = Validation.isBlank(description);
		} while( isInputBlank );

		//Input credit points
		points = Input.acceptIntegerInput("Enter credit points: ");
		
		// set unit fields in enrolment
		enrolment.getSpecificUnit(index).setUnitCode(code);
		enrolment.getSpecificUnit(index).setUnitDescription(description);
		enrolment.getSpecificUnit(index).setCreditPoints(points);

		// check
		//System.out.println("Displaying enrolment after adding unit: "+enrolment.display());

	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	public void removeEnrolment(int index){
		this.enrolments.remove(index);
	}
	public void setEnrolments(ArrayList<Enrolment> enrolments){
		this.enrolments = enrolments;
	}
	public void setSpecificEnrolment(int index, Enrolment enrolment){
		this.enrolments.set(index, enrolment);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	public void startProgram(){

		Enrolment enrolment = new Enrolment();

		boolean isInputBlank; String date; int units;	
		
		do{
			date = Input.acceptStringInput("Enter enrolment date: ");
			isInputBlank = Validation.isBlank(date);
		} while(isInputBlank);
			
		enrolment.setDate(date);

		// input student details
		this.inputStudentDetails(enrolment);

		// input unit details
		units = Input.acceptIntegerInput("Enter number of units to enrol into: ");
		enrolment.setUnitsSize(units);
		this.inputUnitDetails(enrolment);

		// add enrolment to list
		this.addEnrolment(enrolment);
	}

	/////////////////////////////////////// MAIN ////////////////////////////////////////////////
	public static void main(String[] args){
		
		University university = new University();

		int selection;
		boolean selectionValid;
		
		do{
			selection = Input.acceptIntegerInput("Select 1 to enrol a student\nSelect 2 to exit\nPlease make a choice:");
			switch(selection){
				case 1: 
					university.startProgram();
					selectionValid = true;
				case 2: 
					selectionValid = false;
				default:
					selectionValid = true;
			}
		} while(selectionValid && selectionValid != null);

		
		//Enrolment enrolment1 = new Enrolment();
		//System.out.println("The initial enrolment is:\n"+ enrolment1.display() +"\n");
		
		// create default university with default enrolment state
		//University university1 = new University();

		// input enrolment date 
		/*
		Input enrolmentDateInput = new Input();
		String date = enrolmentDateInput.acceptStringInput("Please enter date of enrolment: ");
		enrolment1.setDate(date);

		// test student input into university
		university1.inputStudentDetails(enrolment1);
		System.out.println("The enrolment after student input is:\n"+ enrolment1.display() +"\n");

		// test unit input into university
		university1.inputUnitDetailsOnce(enrolment1);
		System.out.println("The enrolment after unit input is:\n"+ enrolment1.display() +"\n");

		System.out.println("The university after enrolment is:");
		university1.display();
		*/
	}
}