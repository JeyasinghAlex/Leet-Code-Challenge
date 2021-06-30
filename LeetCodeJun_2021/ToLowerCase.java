public class ToLowerCase {

    public String toLowerCase(String s) {

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {

            if (ch >= 65 && ch <= 90) {
                sb.append((char)(ch + 32));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
