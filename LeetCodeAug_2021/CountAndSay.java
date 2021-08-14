public class CountAndSay {

    public static String countAndSay(int n) {

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
