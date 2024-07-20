package InterviewBit;

public class ArraySum {

    public int[] addArrays(int[] A, int[] B) {

        int n = A.length;
        int m = B.length;

        int i = n - 1;
        int j = m - 1;
        int rem = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {

            int a = i >= 0 ? A[i] : 0;
            int b = j >= 0 ? B[j] : 0;

            int sum = a + b + rem;
            sb.append(sum % 10);
            rem = sum / 10;
            --i;
            --j;
        }

        if (rem > 0)
            sb.append(rem);

        int l = sb.length();
        int[] ans = new int[l];
        for (i = 0; i < l; ++i) {
            ans[i] = sb.charAt(l - i - 1) - '0';
        }
        return ans;
    }
}
