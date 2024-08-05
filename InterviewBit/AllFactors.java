package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllFactors {

    public int[] allFactors(int A) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(A); ++i) {
            if (A % i == 0) {
                list.add(i);

                if (i != Math.sqrt(A))
                    list.add(A / i);
            }
        }

        int size = list.size();
        int[] ans = new int[size];
        int idx = 0;
        for (int a : list) {
            ans[idx++] = a;
        }
        Arrays.sort(ans);
        return ans;
    }
}
