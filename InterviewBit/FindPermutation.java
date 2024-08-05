package InterviewBit;

import java.util.ArrayList;

public class FindPermutation {

    public ArrayList<Integer> findPerm(final String A, int B) {

        ArrayList<Integer> ans = new ArrayList<>();

        int hi = B;
        int lo = 1;

        for (int i = 0; i < A.length(); ++i) {

            char ch = A.charAt(i);
            if (ch == 'I')
                ans.add(lo++);
            else
                ans.add(hi--);
        }
        ans.add(lo);

        return ans;
    }
}
