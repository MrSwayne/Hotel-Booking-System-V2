package ie.ul.hbs2.rewards;

public class SilverReward implements IReward {
	
	SilverReward() {

		
	}

	@Override
	public float get_discount() {
		return 10;
	}
}
