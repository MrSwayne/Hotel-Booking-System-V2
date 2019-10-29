package ie.ul.hbs2.rewards;

public class VIPReward implements IReward {

	VIPReward() {

	}

	@Override
	public float get_discount() {
		return 25;
	}
}
