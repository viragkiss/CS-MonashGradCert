//////////////////////////////////////////// Student Class ////////////////////////////////////////////

public class Student{
	
	private String name;
	private String address;
	private String phoneNo;
	private String email;

	public Student(){
		this.name = "Firstname Lastname";
		this.address = "No. Street Town";
		this.phoneNo = "0000000000";
		this.email = "name@email";
	}

	public Student(String name, String address, String phoneNo, String email){
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	// display method to print object state as string
	public String display(){
		String displayStudent = this.name+"; "+this.address+"; "+this.phoneNo+"; "+this.email+".";
		System.out.println(displayStudent); // check if the display string can be printed on screen
		return displayStudent;
		//System.out.println(this.name+"; "+this.address+"; "+this.phoneNo+"; "+this.email+".");
	}
	// get methods
	public String getAddress(){
		return this.address;
	}
	public String getEmail(){
		return this.email;
	}
	public String getName(){
		return this.name;
	}
	public String getPhoneNo(){
		return this.phoneNo;
	}
	// set methods
	public void setAddress(String newAddress){
		this.address = newAddress;
	}
	public void setEmail(String newEmail){
		this.email = newEmail;
	}
	public void setName(String newName){
		this.name = newName;
	}
	public void setPhoneNo(String newPhoneNo){
		this.phoneNo = newPhoneNo;
	}
}
//////////////////////////////////////////// Unit Class ////////////////////////////////////////////
/* public class Unit{

	private String unitCode;
	private String unitDescription;
	private int creditPoints;

	public Unit(){
		this.unitCode = "#00000";
		this.unitDescription = "description";
		this.creditPoints = -1;
	}

	public Unit(String code, String description, int points){
		this.unitCode = code;
		this.unitDescription = description;
		this.creditPoints = points;
	}

	public String display(){
		String displayUnit = this.unitCode+"; "+this.unitDescription+"; "+this.creditPoints+".";
		System.out.println(displayUnit); // check if the display string can be printed on screen
		return displayUnit;
	}

	// get methods
	public int getCreditPoints(){
		return this.creditPoints;
	}
	public String getUnitCode(){
		return this.unitCode;
	}
	public String getUnitDescription(){
		return this.unitDescription;
	}

	// set methods
	public void setCreditPoints(int newPoints){
		this.creditPoints = newPoints;
	}
	public void setUnitCode(String newCode){
		this.unitCode = newCode;
	}
	public void setUnitDescription(String newDescription){
		this.unitDescription = newDescription;
	}
} */

//////////////////////////////////////////// Enrolment Class ////////////////////////////////////////////
/* public class Enrolment{

	private String date;
	private Student student;
	private Unit unit;

	public Enrolment(){
		this.date = "Day Month Year";
		this.student = new Student();
		this.unit = new Unit();
	}

	public Enrolment(String date, Student student, Unit unit){

	}

	public display(){

	}

	// get methods
	public String getDate(){
		return this.date;
	}
	public Student getStudent(){
		this.student.display();
		return this.student;
	}
	public Unit getUnit(){
		this.unit.display();
		return this.unit;
	}

	// set methods
	public void setDate(String newDate){
		this.date = newDate;
	}
	public void setStudent(Student newStudent){
		this.student = newStudent;
	}
	public void setUnit(Unit newUnit){
		this.unit = newUnit;
	}

	public static void main(String[] args){

		Student student1 = new Student("Virag Kiss", "5 xxx street", "00-00-000-000", "vk.email.com");
		student1.display();
		Student thisStudent = student1.getStudent();
		
		Unit unit1 = new Unit("#63754", "Intro to Java", "6");
		unit1.display();
		Unit thisUnit = unit1.getUnit();
		
		Enrolment enrolment1 = new Enrolment("27 March 2023", student1, unit1);
		enrolment1.display();
	}
} */