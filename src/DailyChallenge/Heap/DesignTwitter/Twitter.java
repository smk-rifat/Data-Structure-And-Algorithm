package DailyChallenge.Heap.DesignTwitter;

import java.util.*;

class Twitter {
    HashMap<Integer, Set<Integer>> follow;
	List<HashMap<Integer, Integer>> post;

	public Twitter() {
		follow = new HashMap<>();
		post = new ArrayList<>();
	}

	public void postTweet(int userId, int tweetId) {
          HashMap<Integer, Integer> tweet = new HashMap<>();
		  tweet.put(userId, tweetId);
		  post.add(tweet);
	}

	public List<Integer> getNewsFeed(int userId) {
		List<Integer> newsFeed = new ArrayList<>();
		for (HashMap<Integer, Integer> tweet : post){
			for (Map.Entry<Integer, Integer> entry : tweet.entrySet()){
				int tweeterId = entry.getKey();
				int tweetId = entry.getValue();
				if (userId == tweeterId || follow.containsKey(userId) && follow.get(userId).contains(tweeterId)){
					newsFeed.add(tweetId);
				}
			}
			Collections.reverse(newsFeed);

			if (newsFeed.size() > 10){
				newsFeed = newsFeed.subList(0,10);
			}
		}
		return newsFeed;
    }

	public void follow(int followerId, int followeeId) {
          if (!follow.containsKey(followerId)){
			  follow.put(followerId, new HashSet<>());
		  }
		  follow.get(followerId).add(followeeId);
	}

	public void unfollow(int followerId, int followeeId) {
		if (follow.containsKey(followerId)) follow.get(followerId).remove(followeeId);
	}
}

/**
 * Example usage:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId, tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId, followeeId);
 * obj.unfollow(followerId, followeeId);
 */
