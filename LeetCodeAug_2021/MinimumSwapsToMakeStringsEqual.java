public class MinimumSwapsToMakeStringsEqual {

    public int minimumSwap(String s1, String s2) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for (int i = 0; i < s1.length(); ++i) {

            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (ch1 == ch2) {
                continue;
            }

            if (ch1 == 'x') {
                ++x1;
            } else {
                ++y1;
            }

            if (ch2 == 'x') {
                ++x2;
            } else {
                ++y2;
            }
        }

        if ((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0) {
            return -1;
        }
        return x1 / 2 + y1 / 2 + (x1 % 2) * 2;
    }
}
