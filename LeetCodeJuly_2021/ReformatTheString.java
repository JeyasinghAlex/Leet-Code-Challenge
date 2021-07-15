public class ReformatTheString {

    public String reformat(String s) {

        int l = 0, d = 0;
        StringBuilder letter = new StringBuilder();
        StringBuilder digit = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                ++l;
                letter.append(ch);
            } else {
                digit.append(ch);
                ++d;
            }
        }
        if (Math.abs(l - d) > 1) {
            return "";
        }

        if (d > l) {
            StringBuilder temp = letter;
            letter = digit;
            digit = temp;
        }
        int i = 0, j = 0;
        while (i < letter.length() || j < digit.length()) {

            if (i < letter.length()) {
                result.append(letter.charAt(i++));
            }

            if (j < digit.length()) {
                result.append(digit.charAt(j++));
            }

        }
        return result.toString();
    }
}
