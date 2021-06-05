package LeetCodeMay_2021;

import java.util.PriorityQueue;
import java.util.Queue;

public class ConstructTargetArrayWithMultipleSums {

    public boolean isPossible(int[] target) {

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;

        for (int num : target) {
            sum += num;
            queue.add(num);
        }

        while (queue.peek() != 1) {
            int peek = queue.poll();
            sum -= peek;
            if (peek <= sum || sum <= 0) {
                return false;
            }

            peek = peek % sum;
            sum = sum + peek;
            queue.add(peek);
        }
        return true;
    }
}
