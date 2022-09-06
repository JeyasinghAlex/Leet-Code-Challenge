public class CountAndSay {

    public String countAndSay(int n) {

        String s = "1";

        for (int i = 1; i < n; ++i) {
            s = count(s);
        }
        return s;
    }

    private String count(String s) {

        int n = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (i < n) {

            int count = 1;
            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                ++count;
                ++i;
            }
            sb.append(count).append(s.charAt(i));
            ++i;
        }
        return sb.toString();
    }

    public static String countAndSay_1(int n) {

        int i = 1;
        if (n <= 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder("1");
        while (i < n) {

            int count = 1;
            StringBuilder temp = new StringBuilder();

            for (int j = 1; j < sb.length(); ++j) {
                if (sb.charAt(j) == sb.charAt(j - 1)) {
                    ++count;
                } else {
                    temp.append(count);
                    temp.append(sb.charAt(j - 1));
                    count = 1;
                }
            }
            temp.append(count);
            temp.append(sb.charAt(sb.length() - 1));
            sb = temp;
            ++i;
        }
        return sb.toString();
    }
}
