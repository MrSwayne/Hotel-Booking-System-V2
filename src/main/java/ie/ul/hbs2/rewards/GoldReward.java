package ie.ul.hbs2.rewards;

public class GoldReward implements IReward {
	
	GoldReward() {

	}

	@Override
	public float get_discount() {

		return 15;
	}
}
