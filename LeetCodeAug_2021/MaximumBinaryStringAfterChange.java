public class MaximumBinaryStringAfterChange {

    public String maximumBinaryString(String binary) {

        StringBuilder sb = new StringBuilder();
        int startOne = 0;
        for (char ch : binary.toCharArray()) {
            if (ch == '1') {
                startOne++;
            } else {
                break;
            }
        }

        int one = 0;
        int zero = 0;
        for (int i = startOne; i < binary.length(); ++i) {
            if (binary.charAt(i) == '0') {
                ++zero;
            } else {
                ++one;
            }
        }

        for (int i = 0; i < startOne; ++i) {
            sb.append('1');
        }

        for (int i = 1; i < zero; ++i) {
            sb.append('1');
        }

        if (zero > 0) {
            sb.append('0');
        }

        for (int i = 0; i < one; ++i) {
            sb.append('1');
        }

        return sb.toString();
    }
}
