public class SplitStringInBalancedStrings {

    public int balancedStringSplit(String s) {

        int l = 0, r = 0, res = 0, sum = 0;
        for (char ch : s.toCharArray()) {

            sum += ch == 'R' ? 1 : -1;
            if (sum == 0) {
                ++res;
            }
        }
        return res;
    }

    public int balancedStringSplit_1(String s) {

        int l = 0, r = 0, res = 0;
        for (char ch : s.toCharArray()) {

            if (ch == 'L') {
                ++l;
            } else if (ch == 'R') {
                ++r;
            }

            if (l == r) {
                ++res;
            }
        }
        return res;
    }
}
