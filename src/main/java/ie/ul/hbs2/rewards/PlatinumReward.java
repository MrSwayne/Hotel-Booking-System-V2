package ie.ul.hbs2.rewards;

public class PlatinumReward implements IReward {

	PlatinumReward() {

	}

	@Override
	public float get_discount() {
		return 20;
	}
}
