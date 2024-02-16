public class Item{
	
	private String id;
	// in case probabilities of different items are the same, a non-default item can be identified by its id
	private int probability;

	public Item(){
		this.id = "unknown";
		this.probability = -1;
	}

	public Item(String id, int probability){
		this.id = id;
		this.probability = probability;
	}

	public String getId(){
		return this.id;
	}

	public int getProbability(){
		return this.probability;
	}

	public void setId(String newId){
		this.id = newId;
	}

	public void setProbability(int newProbability){
		this.probability = newProbability;
	}
}