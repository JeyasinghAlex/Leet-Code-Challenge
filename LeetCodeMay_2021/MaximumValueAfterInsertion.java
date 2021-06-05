package LeetCodeMay_2021;

public class MaximumValueAfterInsertion {

    public String maxValue(String n, int x) {

        if (n.startsWith("-")) {
            for (int i = 1; i < n.length(); ++i) {
                if (n.charAt(i) - '0' > x) {
                    return n.substring(0, i) + x + n.substring(i);
                }
            }
            return n + x;
        } else {
            for (int i = 0; i < n.length(); ++i) {
                if (n.charAt(i) - '0' < x) {
                    return n.substring(0, i) + x + n.substring(i);
                }
            }
            return n + x;
        }
    }
}
