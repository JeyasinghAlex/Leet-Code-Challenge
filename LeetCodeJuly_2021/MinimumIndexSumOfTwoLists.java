import java.util.*;

public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {

        TreeMap<Integer, List<String>> ans = new TreeMap<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; ++i) {
            if (map.containsKey(list2[i])) {
                int idx = map.get(list2[i]);
                if (!ans.containsKey(i + idx)) {
                    ans.put(i + idx, new ArrayList<>());
                }
                ans.get(i + idx).add(list2[i]);
            }
        }

        int size =  ans.firstEntry().getValue().size();
        String[] res = new String[size];
        int idx = 0;
        for (String s : ans.firstEntry().getValue()) {
            res[idx++] = s;
        }
        return res;
    }
}
