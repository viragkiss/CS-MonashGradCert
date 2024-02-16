public class Cloak extends Item{
	
	public Cloak(){
		super();
	}

	public Cloak(String id, int probability){
		super(id, probability);
	}

	public String getId(){
		return super.getId();
	}

	public int getProbability(){
		return super.getProbability();
	}

	public void setId(String newId){
		super.setId(newId);
	}

	public void setProbability(int newProbability){
		super.setProbability(newProbability);
	}
}