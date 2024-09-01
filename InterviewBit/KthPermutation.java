package InterviewBit;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

    public int[] findPerm(int A, long B) {

        long fact = 1L;
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[A];
        int idx = 0;

        for(int i = 1; i < A; ++i) {
            fact = fact * i;
            list.add(i);
        }
        list.add(A);

        B = B - 1;
        while (true) {
            int part = (int) (B / fact);
            ans[idx++] = list.get(part);
            list.remove(part);
            if (list.size() == 0)
                break;

            B = B % fact;
            fact = fact / list.size();
        }
        return ans;
    }
}
