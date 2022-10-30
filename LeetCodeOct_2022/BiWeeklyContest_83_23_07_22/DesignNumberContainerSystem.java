package BiWeeklyContest_83_23_07_22;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignNumberContainerSystem {

    private Map<Integer, Integer> map;
    private Map<Integer, TreeSet<Integer>> hmst;
    public DesignNumberContainerSystem() {
        this.map = new HashMap<>();
        this.hmst = new HashMap<>();
    }

    public void change(int index, int number) {

        if (map.containsKey(index)) {
            int temp = map.get(index);
            hmst.get(temp).remove(index);
        }
        map.put(index, number);
        hmst.putIfAbsent(number, new TreeSet<>());
        hmst.get(number).add(index);
    }

    public int find(int number) {

        if (!hmst.containsKey(number) || hmst.get(number).isEmpty()) {
            return -1;
        }
        return hmst.get(number).first();
    }
}
