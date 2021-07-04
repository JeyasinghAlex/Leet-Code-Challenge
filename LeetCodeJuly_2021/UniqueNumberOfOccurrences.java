import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n ,0) + 1);
        }

        for (int n : map.values()) {
            if (!set.add(n)) {
                return false;
            }
        }
        return true;
    }
}
