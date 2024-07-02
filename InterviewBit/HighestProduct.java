package InterviewBit;

import java.util.ArrayList;

public class HighestProduct {

    public int maxp3(ArrayList<Integer> A) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int n : A) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if (n > max2) {
                max3 = max2;
                max2 = n;
            }
            else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            }
            else if (n < min2) {
                min2 = n;
            }
        }

        int m1 = max1 * max2 * max3;
        int m2 = min1 * min2 * max1;
        return Math.max(m1, m2);
    }
}
