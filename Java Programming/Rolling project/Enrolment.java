// @author: Virag Kiss
// @version: 2
// @date: 4/4/2023

public class Enrolment{

	private String date;
	private Student student;
	private Unit[] units;  // fixed-length array of Unit objects

	public Enrolment(){
		this.date = "Day Month Year";
		this.student = new Student();
		this.units = new Unit[0];
	}

	public Enrolment(String date, Student student, Unit[] units){
		this.date = date;
		this.student = student;
		this.units = units;
	}

	public String display(){
		String displayEnrolment = this.date + " " + this.student.display();
		for (Unit unit: this.units) {
            displayEnrolment = displayEnrolment + " " + unit.display();  // concantenate strings
        }
		System.out.println(displayEnrolment);
		return displayEnrolment;
	}

	// get methods
	public String getDate(){
		return this.date;
	}
	public Student getStudent(){
		return this.student;
	}
	public Unit[] getUnits(){
		return this.units;
	}
	public int getUnitsSize(){
		return this.units.length;
	}
	public Unit getSpecificUnit(int index){
		return this.units[index];
	}

	// set methods
	public void setDate(String newDate){
		this.date = newDate;
	}
	public void setStudent(Student newStudent){
		this.student = newStudent;
	}
	public void setUnits(Unit[] newUnit){
		this.units = newUnit;
	}
	public void setUnitsSize(int size){
		//this.units = new Unit[size];

		// copy existing elements in array into new temporary array of desired length
		Unit[] copyUnits = new Unit[size];
		for (int i = 0; i < this.units.length; i++) {
    		copyUnits[i] = this.units[i];
		}
		// checks
		System.out.println("Size of units array before setUnitsSize: "+this.units.length);
		System.out.println("Size of units array after setUnitsSize: "+copyUnits.length);

		this.units = copyUnits;
		//get units field to point to same memory location as copyUnits, copyUnits gets deleted after method is done
	}
	public void setSpecificUnit(int index, String code, String description, int points){
		this.units[index].setUnitCode(code);
		this.units[index].setUnitDescription(description);
		this.units[index].setCreditPoints(points);
		// check
		System.out.println("New unit in unit array is: "+this.units.[index].display());
	}

	// access student constructor from Enrolment class for better design
	public void createStudent(String name, String address, String phoneNo, String email){
		this.student = new Student(name, address, phoneNo, email);
		System.out.println("Student has been created!");
	}
}