package LeetCodeMay_2021;

public class StringToInteger_Atoi {

    public int myAtoi(String s) {

        int i =0;
        boolean isMinus = false;
        long num = 0;

        if (s.isEmpty()) {
            return 0;
        }

        for (; i < s.length() && s.charAt(i) == ' '; ++i);



        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-')
                isMinus = true;
            ++i;
        }

        while (i < s.length() && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {

            num = (num * 10) + s.charAt(i) - '0';

            if (isMinus && num > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }


            if (!isMinus && num >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            ++i;
        }

        return (int)(isMinus ? -num : num);
    }
}
