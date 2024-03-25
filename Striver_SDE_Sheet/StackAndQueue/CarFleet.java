package StackAndQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        double[] timeArray = new double[target];

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            double time = (double) (target - position[i]) / speed[i];
            timeArray[position[i]] = time;
        }

        double prev = 0.0;
        for (int i = target - 1; i >= 0; --i) {

            double curr = timeArray[i];
            if (curr > prev) {
                ++ans;
                prev = curr;
            }
        }

        return ans;
    }

    public int carFleet_1(int target, int[] position, int[] speed) {

        int n = position.length;
        List<int[]> list = new ArrayList<>();
        Stack<Double> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            list.add(new int[]{position[i], speed[i]});
        }

        Collections.sort(list, (a, b) -> {
            if (a[0] > b[0]) {
                return 1;
            }
            return -1;
        });

        for (int[] car : list) {
            double step = (double)(target - car[0]) / car[1];
            while (!st.isEmpty() && step >= st.peek()) {
                st.pop();
            }
            st.push(step);
        }
        return st.size();
    }
}
