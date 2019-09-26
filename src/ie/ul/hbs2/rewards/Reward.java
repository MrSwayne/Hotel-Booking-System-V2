package ie.ul.hbs2.rewards;

public abstract class Reward {

	protected float discountPercent = 0;
	
	public Reward(float discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public float getDiscountPercent() {
		return this.discountPercent;
	}
}
