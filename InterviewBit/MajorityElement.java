package InterviewBit;

import java.util.List;

public class MajorityElement {

    public int majorityElement(final List<Integer> A) {

        int majorityElement = Integer.MIN_VALUE;
        int cnt = 0;

        for (int a : A) {
            if (cnt == 0) {
                ++cnt;
                majorityElement = a;
            }
            else if (a == majorityElement) {
                ++cnt;
            }
            else {
                --cnt;
            }
        }
        return majorityElement;
    }
}
