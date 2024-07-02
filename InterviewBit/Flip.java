package InterviewBit;

public class Flip {

    public int[] flip(String A) {

        int n = A.length();
        int cnt = 0;
        int left = -1;
        int right = -1;
        int start = 0;
        int max = 0;

        for (int i = 0; i < n; ++i) {

            if(A.charAt(i) == '0')
                ++cnt;
            else
                --cnt;

            if (cnt < 0) {
                cnt = 0;
                start = i + 1;
            }

            if (cnt > max) {
                max = cnt;
                left = start + 1;
                right = i + 1;
            }
        }

        if (left == -1 || right == -1)
            return new int[]{};

        return new int[]{left, right};
    }
}
