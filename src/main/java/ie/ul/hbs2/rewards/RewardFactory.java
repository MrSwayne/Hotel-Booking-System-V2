package ie.ul.hbs2.rewards;

import java.util.HashMap;
import java.util.Map;

public abstract class RewardFactory {
	
	private static Map<Integer, IReward> rewardMap;
	private static IReward nullReward = new NoneReward();
	
	public static IReward getReward(int reward) {
		if(rewardMap == null)
			rewardMap = new HashMap<>();
		
		IReward rew = rewardMap.get(reward);
		if(rew != null)
			return rew;
		
		IReward newReward;
		switch(reward) {
			case 1:
				newReward = new BronzeReward();
			break;
			
			case 2:
				newReward = new SilverReward();
			break;
			case 3:
				newReward = new GoldReward();
			break;
			
			case 4:
				newReward = new PlatinumReward();
			break;
			
			case 5:
				newReward = new VIPReward();
			break;
			
			default: return nullReward;
		}
		
		rewardMap.put(reward, newReward);
		return newReward;
	}
}
