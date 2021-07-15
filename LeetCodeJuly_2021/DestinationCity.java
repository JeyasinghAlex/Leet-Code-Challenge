import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {

    public String destCity(List<List<String>> paths) {

        Map<String, String> map = new HashMap<>();
        for (List<String> list : paths) {

            map.put(list.get(0), list.get(1));
        }

        for (String city : map.values()) {
            if (!map.containsKey(city)) {
                return city;
            }
        }
        return "";
    }

    public String destCity_1(List<List<String>> paths) {

        String start = paths.get(0).get(0);

        Map<String, String> map = new LinkedHashMap<>();
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }

        while (map.get(start) != null) {
            start = map.get(start);
        }
        return start;
    }
}
