package ie.ul.hbs2.rewards;

public class BronzeReward implements IReward {

	BronzeReward() {

	}

	@Override
	public float get_discount() {
		return 5;
	}
}
