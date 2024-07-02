package InterviewBit;

public class Bulbs {

    public int bulbs(int[] A) {

        int n = A.length;
        int cnt = 0;
        boolean isChange = false;

        for (int i = 0; i < n; ++i) {

            if (A[i] == 1 && isChange) {
                isChange = false;
                ++cnt;
            }
            else if (A[i] == 0 && !isChange) {
                isChange = true;
                ++cnt;
            }
        }

        return cnt;
    }
}
