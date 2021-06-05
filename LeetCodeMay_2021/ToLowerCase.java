package LeetCodeMay_2021;

public class ToLowerCase {

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }
            sb.append(ch);
        }
        return new String(sb);
    }
}
