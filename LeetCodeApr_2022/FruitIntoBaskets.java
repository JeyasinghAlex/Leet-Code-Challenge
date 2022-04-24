import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(arr));
    }

    public static int totalFruit(int[] tree) {
        int max = 0, count = 0;
        for (int i = 0, first = 0, second = -1; i < tree.length; i++) {
            count++;
            if (tree[i] == tree[first]) {
                first = i;
            } else if (second == -1 || tree[i] == tree[second]) {
                second = i;
            } else {
                max = Math.max(count - 1, max);
                count = Math.abs(first - second) + 1;
                first = i - 1;
                second = i;
            }
        }
        return Math.max(count, max);
    }

    public int totalFruit_1(int[] tree) {

        int n = tree.length;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        for (end = 0; end < n; ++end) {
            map.put(tree[end], map.getOrDefault(tree[end], 0) + 1);

            if (map.size() > 2) {
                map.put(tree[start], map.get(tree[start]) - 1);
                map.remove(tree[start++], 0);
            }
        }
        return  end - start;
    }

    public int totalFruit_2(int[] fruits) {

        int n = fruits.length;
        List<int[]> fruitVsCount = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int count = 1;
            while (i < n - 1 && fruits[i] == fruits[i + 1]) {
                ++count;
                ++i;
            }
            fruitVsCount.add(new int[]{fruits[i], count});
            ++i;
        }

        int size = fruitVsCount.size();
        if (size == 1) {
            return fruitVsCount.get(0)[1];
        }
        if (size == 2) {
            return fruitVsCount.get(0)[1] + fruitVsCount.get(1)[1];
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        i = 0;
        while (i < size - 1) {

            list.add(fruitVsCount.get(i)[0]);
            list.add(fruitVsCount.get(i + 1)[0]);
            sum = fruitVsCount.get(i)[1] + fruitVsCount.get(i + 1)[1];

            while (i < size - 2 && list.contains(fruitVsCount.get(i + 2)[0])) {
                sum += fruitVsCount.get(i + 2)[1];
                ++i;
            }
            max = Math.max(max, sum);
            list.clear();
            ++i;
        }
        return max;
    }
}
