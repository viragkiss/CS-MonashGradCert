public class Unit{

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
		//System.out.println(displayUnit); // check if the display string can be printed on screen
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
}