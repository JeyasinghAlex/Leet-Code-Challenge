import java.util.LinkedList;
import java.util.Queue;

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; --j) {
                    arr[j] = arr[j - 1];
                }
                ++i;
            }
        }
    }

    public void duplicateZeros_1(int[] arr) {

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < arr.length; ++i) {

            qu.offer(arr[i]);

            if (arr[i] == 0) {
                qu.offer(0);
            }

            arr[i] = qu.poll();
        }
    }
}
