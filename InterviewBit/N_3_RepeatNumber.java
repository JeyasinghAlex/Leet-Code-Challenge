package InterviewBit;

import java.util.List;

public class N_3_RepeatNumber {

    public int repeatedNumber(final List<Integer> list) {

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int majority1 = 0;
        int majority2 = 0;
        int majority3 = 0;

        int n = list.size();
        for (int num : list) {

            if (cnt1 == 0 || majority1 == num) {
                majority1 = num;
                ++cnt1;
            }
            else if (cnt2 == 0 || majority2 == num) {
                majority2 = num;
                ++cnt2;
            }
            else if (cnt3 == 0 || majority3 == num) {
                majority3 = num;
                ++cnt3;
            }
            else {
                --cnt1;
                --cnt2;
                --cnt3;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        cnt3 = 0;

        for (int a : list) {
            if (a == majority1)
                ++cnt1;
            else if (a == majority2)
                ++cnt2;
            else if (a == majority3)
                ++cnt3;
        }
        if (cnt1 > n / 3)
            return majority1;
        if (cnt2 > n / 3)
            return majority2;
        if (cnt3 > n / 3)
            return majority3;

        return -1;
    }
}
