import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumActivities {

    class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class MySort implements Comparator<Activity> {

        public int compare(Activity a, Activity b) {

            if (a.end > b.end) {
                return 1;
            }
            return -1;
        }
    }

    public int maximumActivities(List<Integer> start, List<Integer> end) {

        int n = start.size();

        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            activities.add(new Activity(start.get(i), end.get(i)));
        }

        Collections.sort(activities, new MySort());

        int limit = activities.get(0).end;
        int ans = 1;

        for (Activity activity : activities) {

            if (activity.start >= limit) {
                ++ans;
                limit = activity.end;
            }
        }
        return ans;
    }
}
