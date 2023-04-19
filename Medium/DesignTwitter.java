class Twitter {
    HashMap<Integer, ArrayList<Integer>> followings;
    ArrayList<ArrayList<Integer>> tweets;

    public Twitter() {
        followings = new HashMap<>();    
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        ArrayList<Integer> currentTweet = new ArrayList<>();
        currentTweet.add(userId);
        currentTweet.add(tweetId);
        tweets.add(currentTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> following = followings.get(userId);
        if (following == null) {
            following = new ArrayList<>();
        }
        int counter = 0;
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = tweets.size() - 1; i >=0; i--) {
            if (counter == 10) {
                return results;
            }
            if (tweets.get(i).get(0) == userId || following.contains(tweets.get(i).get(0))) {
                counter++;
                results.add(tweets.get(i).get(1));
            }
        }
        return results;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followings.containsKey(followerId)) {
            ArrayList<Integer> follows = new ArrayList<>();
            follows.add(followeeId);
            followings.put(followerId, follows);
        } else {
            followings.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        ArrayList<Integer> curr = followings.get(followerId);
        if (curr == null) {
            return;
        }
        int toRemove = curr.indexOf(followeeId);
        if (toRemove == -1) {
            return;
        }
        curr.remove(toRemove);
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