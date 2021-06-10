package LeetCodeJun_2021;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar_I {


    private List<int[]> list;
    public MyCalendar_I() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (list.isEmpty()) {
            list.add(new int[]{start, end});
        }

        for (int[] arr : list) {
            if (start > arr[0] && start < arr[1] || end > arr[0] && end < arr[1] || start >= arr[0] && start < arr[1]
                    || end >= arr[0] && end < arr[1]) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}
