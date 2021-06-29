public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {

        if (s.length() <= 1) {
            return false;
        }

        StringBuilder sb;
        String str = "";
        for (int i = 0; i < s.length() / 2; ++i) {

            sb = new StringBuilder();
            str += s.charAt(i);

            while (sb.length() < s.length()) {
                sb.append(str);
            }

            if (sb.toString().equals(s)) {
                return true;
            }
        }
        return false;

    }
}
