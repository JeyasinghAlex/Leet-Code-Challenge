package InterviewBit;

public class NextSmallestPalindrome {

    public String solve(String A) {

        int n = A.length();
        StringBuilder sb = new StringBuilder();
        boolean isAll9 = isAll9(A);
        if (isAll9) {
            sb.append('1');
            for (int i = 0; i < n - 1; ++i) {
                sb.append('0');
            }
            sb.append('1');
            return sb.toString();
        }

        if (n % 2 == 1) {
            return solveForOdd(A);
        }
        return solveForEven(A);
    }

    private String solveForEven(String s) {

        int n = s.length();
        String s1 = "";
        String s2 = "";
        int mid = n >>> 1;
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (i < mid) {
                s1 += ch;
            }
            else {
                s2 += ch;
            }
        }

        String temp = s1;
        String reverse = reverse(s1);
        if (reverse.compareTo(s2) > 0) {
            return s1 + reverse;
        }
        String newS1 = addOne(s1);
        reverse = reverse(newS1);
        return newS1 + reverse;
    }

    private String solveForOdd(String s) {

        int n = s.length();
        String s1 = "";
        String s2 = "";
        String s3 = "";
        int mid = n >>> 1;

        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (i <= mid) {
                s1 += ch;

                if (i != mid) {
                    s3 += ch;
                }
            }
            else {
                s2 += ch;
            }
        }

        String temp = s3;
        String reverse = reverse(temp);

        if (reverse.compareTo(s2) > 0) {
            return s1 + reverse;
        }

        String newS1 = addOne(s1);
        temp = "";

        for (int i = 0; i < newS1.length() - 1; ++i) {
            temp += newS1.charAt(i);
        }

        reverse = reverse(temp);

        return newS1 + reverse;
    }


    private String reverse(String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; --i) {
            reverse += s.charAt(i);
        }
        return reverse;
    }

    private String addOne(String s) {
        char[] arr = s.toCharArray();
        int carry = 1;
        int n = s.length();

        while (n-- > 0) {
            int digit = arr[n] - '0' + carry;
            carry = digit / 10;
            digit = digit % 10;
            arr[n] = (char) (digit + '0');
        }
        if (carry > 0) {
            return carry + new String(arr);
        }
        return new String(arr);
    }

    private boolean isAll9(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != '9')
                return false;
        }
        return true;
    }
}
