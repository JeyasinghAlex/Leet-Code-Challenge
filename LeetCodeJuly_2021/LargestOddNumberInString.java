public class LargestOddNumberInString {

    public String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; --i) {
            int n = num.charAt(i) - '0';
            if ((n & 1) == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
