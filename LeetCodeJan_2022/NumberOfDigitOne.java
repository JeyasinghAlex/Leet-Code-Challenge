public class NumberOfDigitOne {

    public int countDigitOne(int n) {

        String s = n + "";
        int result = 0;
        int l = s.length();

        for (int i = 0; i < s.length(); ++i) {
            int currentDigit = 0;
            int lowerDigit = 0;
            int total = 0;
            char ch = s.charAt(i);
            if (ch == '0') {
                continue;
            }
            if (ch > '1') {
                currentDigit = (int)Math.pow(10, (l -i - 1));
                lowerDigit = (l - i - 1) * (currentDigit / 10);
                lowerDigit = (ch - '0') * lowerDigit;
                total = lowerDigit + currentDigit;
                result += total;
            } else {
                if (i == l - 1) {
                    result += 1;
                } else {
                    for (int j = i + 1; j < s.length(); ++j) {
                        currentDigit = (currentDigit * 10) + (s.charAt(j) - '0');
                    }
                    currentDigit += 1;
                    lowerDigit = (l - i - 1) * ((int)Math.pow(10, (l - i - 1)) / 10);
                    total = lowerDigit + currentDigit;
                    result += total;
                }
            }
        }
        return result;
    }
}
