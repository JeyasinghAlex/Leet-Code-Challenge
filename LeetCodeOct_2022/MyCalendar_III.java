import java.util.TreeMap;

public class MyCalendar_III {

    private TreeMap<Integer, Integer> treeMap;
    public MyCalendar_III() {
        this.treeMap = new TreeMap<>();
    }

    public int book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);

        int onGoingEvent = 0;
        int max = 0;
        for (int event : treeMap.values()) {
            onGoingEvent += event;
            max = Math.max(max, onGoingEvent);
        }
        return max;
    }
}
