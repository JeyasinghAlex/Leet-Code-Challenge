package InterviewBit;

public class BalanceArray {

    public int solve(int[] A) {

        int n = A.length;
        int odd = 0;
        int even = 0;

        for (int i = 0; i < n; ++i) {

            if (i % 2 == 0)
                even += A[i];
            else
                odd += A[i];
        }

        int od = 0;
        int ev = 0;
        int cnt = 0;

        for (int i = 0; i < n; ++i) {

            if (i % 2 == 0)
                even -= A[i];
            else
                odd -= A[i];

            int sumOdd = ev + odd;
            int sumEven = od + even;
            if (sumOdd == sumEven)
                ++cnt;

            if (i % 2 == 0)
                ev += A[i];
            else
                od += A[i];

        }
        return cnt;
    }
}
