public class Portal{

	private String direction;
	private int pOpen;
	private int pExit;
	private int pPolice;
	private boolean isOpen;
	private boolean isExit;

	public Portal(){
		this.direction = "Unknown";
		this.pOpen = -1;
		this.pExit = -1;
		this.pPolice = -1;
		this.isOpen = false;
		this.isExit = false;
	}

	public Portal(String direction, int pOpen, int pExit, int pPolice){
		this.direction = direction;
		this.pOpen = pOpen;
		this.pExit = pExit;
		this.pPolice = pPolice;
		this.isOpen = false;
		this.setIsOpen();
		this.isExit = false;
		this.setIsExit();
	}

	public String display(){
		// use first string in case of no visualization
		//String displayString = "Direction: " + this.direction + " Open: " + this.pOpen +"%" + " Exit: " + this.pExit +"%" 
		//+ " Police: " + this.pPolice +"%" + " Is Open? " +this.isOpen + " Is Exit? " +this.isExit;
		String displayString = "Direction: "+this.direction+" Open: "+this.pOpen +"%"+" Exit: "+this.pExit +"%"+" Police: "+this.pPolice+"%";
		return displayString;
	}

	public String getDirection(){
		return this.direction;
	}

	public int getPOpen(){
		return this.pOpen;
	}

	public int getPExit(){
		return this.pExit;
	}

	public int getPPolice(){
		return this.pPolice;
	}

	public boolean getIsOpen(){
		return this.isOpen;
	}

	public boolean getIsExit(){
		return this.isExit;
	}

	public void setDirection(String direction){
		this.direction = direction;
	}

	public void setPOpen(int pOpen){
		this.pOpen = pOpen;
	}

	public void setPExit(int pExit){
		this.pExit = pExit;
	}

	public void setPPolice(int pPolice){
		this.pPolice = pPolice;
	}

	// decide if open based on probability
	public void setIsOpen(){
		this.isOpen = ( Math.random() < (this.pOpen / 100.0) ) ? true : false;
	}
	
	// decide if exit based on probability
	public void setIsExit(){
		this.isExit = ( Math.random() < (this.pExit / 100.0) ) ? true : false;
	}
}
