package BiweeklyContest_89_15_10_22;

public class NumberOfValidClockTimes {

    public int countTime(String time) {

        char t1 = time.charAt(0);
        char t2 = time.charAt(1);
        char m1 = time.charAt(3);
        char m2 = time.charAt(4);

        int ans = 1;

        if (t1 == '?') {
            if (t2 == '?')
                ans *= 24;
            else if (t2 <= '3')
                ans *= 3;
            else
                ans *= 2;
        }
        else if (t2 == '?') {
            if (t1 <= '1')
                ans *= 10;
            else
                ans *= 4;
        }
        if (m1 == '?') {
            ans *= 6;
        }
        if (m2 == '?') {
            ans *= 10;
        }
        return ans;
    }
}
