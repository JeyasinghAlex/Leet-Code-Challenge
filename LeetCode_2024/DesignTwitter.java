package LeetCode_2024;

import java.util.*;

public class DesignTwitter {

    private Map<Integer, User> userMap;
    public DesignTwitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }

        Set<Integer> users = userMap.get(userId).followed;
        Queue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int user : users) {
            Tweet t = userMap.get(user).tweetHead;
            if (t != null) {
                pq.offer(t);
            }
        }
        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            ++n;
            if (t.next != null) {
                pq.offer(t.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {

        if(!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!userMap.containsKey(followerId)) {
            return ;
        }
        userMap.get(followerId).unFollow(followeeId);
    }
}

class User {
    public int id;
    public Set<Integer> followed;
    public Tweet tweetHead;

    public User(int id) {
        this.id = id;
        this.followed = new HashSet<>();
        follow(id);
    }

    public void follow(int id) {
        followed.add(id);
    }

    public void unFollow(int id) {
        followed.remove(id);
    }

    public void post(int id) {
        Tweet t = new Tweet(id);
        t.next = tweetHead;
        tweetHead = t;
    }
}

class Tweet {
    public int id;
    public int time;
    public Tweet next;
    private static int timeStamp;

    public Tweet(int id) {
        this.id = id;
        this.time = ++timeStamp;
    }
}
