package ie.ul.hbs2.rewards;

import java.util.HashMap;
import java.util.Map;

public abstract class RewardFactory {
	
	private static Map<String, IReward> rewardMap;
	private static IReward nullReward = new NoneReward();
	
	public static IReward getReward(String reward) {
		reward = reward.toUpperCase();
		if(rewardMap == null)
			rewardMap = new HashMap<>();
		
		IReward rew = rewardMap.get(reward);
		if(rew != null)
			return rew;
		
		IReward newReward;
		switch(reward) {
			case "BRONZE": 
				newReward = new BronzeReward();
			break;
			
			case "SILVER": 
				newReward = new SilverReward();
			break;
			case "GOLD": 
				newReward = new GoldReward();
			break;
			
			case "PLATINUM": 
				newReward = new PlatinumReward();
			break;
			
			case "VIP": 
				newReward = new VIPReward();
			
			break;
			
			default: return nullReward;
		}
		
		rewardMap.put(reward, newReward);
		return newReward;
	}
}
