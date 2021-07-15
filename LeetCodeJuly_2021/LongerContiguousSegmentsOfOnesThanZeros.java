public class LongerContiguousSegmentsOfOnesThanZeros {

    public boolean checkZeroOnes(String s) {

        int one = 0;
        int zero = 0;
        int ol = 0;
        int zl = 0;
        for (char ch : s.toCharArray()) {

            if (ch == '1') {
                ol = Math.max(ol, ++one);
                zero = 0;
            } else if (ch == '0') {
                zl = Math.max(zl, ++zero);
                one = 0;
            }
        }
        return ol > zl;
    }

    public boolean checkZeroOnes_1(String s) {

        int ol = 0;
        int zl = 0;
        int i = 0;
        while (i < s.length()) {
            int one = 0;
            int zero = 0;
            while (i < s.length() && s.charAt(i) == '1') {
                ++i;
                ++one;
            }
            ol = Math.max(ol, one);

            while (i < s.length() && s.charAt(i) == '0') {
                ++i;
                ++zero;
            }
            zl = Math.max(zl, zero);
        }
        return ol > zl;
    }
}
