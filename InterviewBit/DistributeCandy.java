package InterviewBit;

import java.util.*;
public class DistributeCandy {

    public int candy(ArrayList<Integer> A) {

        int ans = 0;
        int n = A.size();
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        for (int i = 1; i < n; ++i) {
            if(A.get(i) > A.get(i - 1)) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; --i) {
            if (A.get(i) > A.get(i + 1)) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }

        for (int i = 0; i < n; ++i) {
            ans += arr[i];
        }

        return ans;
    }
}
