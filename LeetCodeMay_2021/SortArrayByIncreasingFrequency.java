package LeetCodeMay_2021;

import java.util.*;

public class SortArrayByIncreasingFrequency {

    public int[] usingMapAndList(int[] nums) {
        System.out.println(Arrays.toString(nums));
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
        }

        list.sort((a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b));
        System.out.println(list);
        int index = 0;
        while (!list.isEmpty()) {
            nums[index++] = list.remove(0);
        }

        return nums;

    }


    public int[] usingMapAndQueue(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> qu = new PriorityQueue<>((x, y) -> map.get(x) == map.get(y) ? y - x : map.get(x) - map.get(y));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        for (int num : nums) {
            qu.offer(num);
        }
        int index = 0;
        while (!qu.isEmpty()) {
            nums[index++] = qu.poll();
        }

        return nums;

    }
}
