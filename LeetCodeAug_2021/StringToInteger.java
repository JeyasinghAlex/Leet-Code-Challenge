public class StringToInteger {

    public int myAtoi(String s) {

        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            ++i;
        }

        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            ++i;
        }

        long ans = 0;
        boolean isMinus = i > 0 && s.charAt(i - 1) == '-' ? true : false;

        for ( ; i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'; ++i) {
            ans = (ans * 10) + s.charAt(i) - '0';

            if (!isMinus && ans > Integer.MAX_VALUE - 1) {
                return Integer.MAX_VALUE;
            }
            if (isMinus && ans > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return isMinus ? (int) -ans : (int) ans;
    }
}