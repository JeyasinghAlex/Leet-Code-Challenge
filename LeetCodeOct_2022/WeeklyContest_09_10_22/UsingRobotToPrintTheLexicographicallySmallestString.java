package WeeklyContest_09_10_22;

import java.util.Stack;

public class UsingRobotToPrintTheLexicographicallySmallestString {

    public String robotWithString(String s) {
        int N = s.length();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i) - 'a';
        }
        int[] min = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            min[i] = arr[i];
            if (i < N - 1) {
                min[i] = Math.min(min[i], min[i + 1]);
            }
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < N; i++) {
            stack.push(arr[i]);
            while ( !stack.isEmpty() && (i == N - 1 ||stack.peek() <= min[i + 1])) {
                sb.append((char)(stack.pop() + 'a'));
            }
        }
        return sb.toString();
    }
}
