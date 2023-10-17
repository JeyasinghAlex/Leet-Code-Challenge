package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumActivities {

    public int maximumActivities(List<Integer> start, List<Integer> end) {

        int n = start.size();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < n; ++i)
            activities.add(new Activity(start.get(i), end.get(i)));

        Collections.sort(activities, new MySortClass());

        int limit = activities.get(0).end;

        int ans = 1;
        for (int i = 1; i < n; ++i) {
            Activity activity = activities.get(i);
            if (activity.start >= limit) {
                ++ans;
                limit = activity.end;
            }
        }
        return ans;
    }
}

class MySortClass implements Comparator<Activity> {

    @Override
    public int compare(Activity a1, Activity a2) {
        if (a1.end > a2.end)
            return -1;
        return 1;
    }
}

class Activity {

    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
