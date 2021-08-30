public class MaximumValueAfterInsertion {

    public String maxValue(String n, int x) {

        boolean isNegative = false;

        if (n.charAt(0) == '-') {
            isNegative = true;
        }

        if (isNegative) {
            for (int i = 1; i < n.length(); ++i) {
                if (n.charAt(i) - '0' > x) {
                    return  n.substring(0, i) + x + n.substring(i);
                }
            }
        } else {
            for (int i = 0; i < n.length(); ++i) {
                if (x > n.charAt(i) - '0') {
                    return n.substring(0, i) + x + n.substring(i);
                }
            }
        }
        return n + x;
    }
}
