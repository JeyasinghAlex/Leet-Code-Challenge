import java.util.*;

public class BrickWall {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 1));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 1, 2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3, 2));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(2, 4));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(3, 1, 2));
        List<Integer> list5 = new ArrayList<>(Arrays.asList(1, 3, 1, 1));
        List<List<Integer>> tot = new ArrayList<>();
        tot.add(list);
        tot.add(list1);
        tot.add(list2);
        tot.add(list3);
        tot.add(list4);
        tot.add(list5);
        System.out.println(new BrickWall().leastBricks(tot));
    }

    public int leastBricks(List<List<Integer>> wall) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < wall.size(); ++i) {
            List<Integer> list = wall.get(i);
            int count = 0;

            for (int j = 0; j < list.size() - 1; ++j) {
                count += list.get(j);
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
        }

        int maxGap = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxGap = Math.max(entry.getValue(), maxGap);
        }
        return wall.size() - maxGap;
    }
}
