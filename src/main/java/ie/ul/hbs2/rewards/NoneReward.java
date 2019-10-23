package ie.ul.hbs2.rewards;

public class NoneReward implements IReward {

	NoneReward() {

	}

	@Override
	public float get_discount() {
		return 0;
	}
}
