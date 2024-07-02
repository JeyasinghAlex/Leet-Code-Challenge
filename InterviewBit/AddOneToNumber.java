package InterviewBit;

public class AddOneToNumber {

    public int[] plusOne(int[] A) {

        int n = A.length;
        StringBuilder sb = new StringBuilder();
        int rem = 1;

        for (int i = n - 1; i >= 0; --i) {

            int d = A[i];
            int sum = d + rem;

            sb.append(sum % 10);
            rem = sum / 10;
        }

        if (rem > 0)
            sb.append(rem);

        n = sb.length() - 1;
        while (n >= 0 && sb.charAt(n) == '0')
            --n;

        int index = n;
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            char ch = sb.charAt(i);
            ans[index--] = ch - '0';
        }
        return ans;
    }
}
