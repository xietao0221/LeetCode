public class Twitter {
    
    private Map<Integer, Set<Integer>> user;            // userID -> followeeID
    private Map<Integer, Map<Integer, Integer>> tweet;  // userID -> (timeStamp -> tweetID)
    private int timeStamp;
    
    /** Initialize your data structure here. */
    public Twitter() {
        user = new HashMap<>();
        tweet = new HashMap<>();
        timeStamp = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!user.containsKey(userId)) {
            user.put(userId, new HashSet<>());
            tweet.put(userId, new HashMap<>());
        }
        tweet.get(userId).put(timeStamp++, tweetId);
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(!user.containsKey(userId)) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        Queue<Map.Entry<Integer, Integer>> newsFeed = new PriorityQueue<>(new TweetComparator());
        
        // offer all news posted by user himself
        for(Map.Entry<Integer, Integer> entry: tweet.get(userId).entrySet()) {
            newsFeed.offer(entry);
        }
        
        // offer all news posted by user's followees
        for(int tmpUser: user.get(userId)) {
            for(Map.Entry<Integer, Integer> entry: tweet.get(tmpUser).entrySet()) {
                newsFeed.offer(entry);
            }
        }
        
        // pop out news 
        for(int i = 0; i < 10 && !newsFeed.isEmpty(); i++) {
            res.add(newsFeed.poll().getValue());
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        
        if(!user.containsKey(followerId)) {
            user.put(followerId, new HashSet<>());
            tweet.put(followerId, new HashMap<>());
        }
        
        if(!user.containsKey(followeeId)) {
            user.put(followeeId, new HashSet<>());
            tweet.put(followeeId, new HashMap<>());
        }
        
        user.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        
        if(!user.containsKey(followerId) || !user.containsKey(followeeId)) return;
        
        user.get(followerId).remove(followeeId);
    }
    
    class TweetComparator implements Comparator<Map.Entry<Integer, Integer>> {
        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
            return e2.getKey() - e1.getKey();
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */