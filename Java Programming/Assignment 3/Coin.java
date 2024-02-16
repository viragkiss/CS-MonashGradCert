public class Coin extends Item{
	
	private int amount;

	public Coin(){
		super();
		this.amount = -1;
	}

	public Coin(String id, int probability, int amount){
		super(id, probability);
		this.amount = amount;
	}

	public String getId(){
		return super.getId();
	}

	public int getProbability(){
		return super.getProbability();
	}

	public int getAmount(){
		return this.amount;
	}

	public void setId(String newId){
		super.setId(newId);
	}

	public void setProbability(int newProbability){
		super.setProbability(newProbability);
	}

	public void setAmount(int newAmount){
		this.amount = newAmount;
	}
}