import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStoreTimeBasedKeyValueStore {

    private Map<String, TreeMap<Integer, String>> map;
    public TimeBasedKeyValueStoreTimeBasedKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<Integer, String>());
        }
        TreeMap<Integer, String> treeMap = map.get(key);
        treeMap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> treeMap = map.get(key);
        Integer ans = treeMap.floorKey(timestamp);
        if (ans == null) {
            return "";
        }
        return treeMap.get(ans);
    }
}
