public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != '-') {
                temp.append(ch);
            }
        }

        s = temp.toString();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; --i) {

            sb.append(caps(s.charAt(i)));
            ++count;
            if (count % k == 0 && i != 0) {
                sb.append('-');
                count = 0;
            }
        }
        return sb.reverse().toString();
    }

    public String licenseKeyFormatting_1(String s, int k) {

        s = s.toUpperCase().replace("-", "");
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            sb.append(s.charAt(i));
            ++count;
            if (count % k == 0 && i != 0) sb.append('-');
        }
        return sb.reverse().toString();
    }

    public String licenseKeyFormatting_2(String s, int k) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int count = 0;
        for (char ch : s.toCharArray()) {

            if (ch != '-') {
                ++count;
                temp.append(ch);
            }
        }
        s = temp.toString();
        int group = count / k;
        int cnt = count - (group * k);

        for (int i = 0; i < s.length(); ) {
            boolean flag = false;
            while (i < s.length() && cnt-- > 0) {
                sb.append(caps(s.charAt(i++)));
                flag = true;
            }
            cnt = k;
            if (i != s.length() && flag) {
                sb.append('-');
            }
        }
        return sb.toString();
    }

    private char caps(char ch) {

        if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - 32);
        }
        return ch;
    }
}
