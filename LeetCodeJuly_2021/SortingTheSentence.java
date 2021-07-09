import java.util.TreeMap;

public class SortingTheSentence {

    public String sortSentence(String s) {

        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, String> map = new TreeMap<>();

        for (char ch : s.toCharArray()) {

            if (ch >= '0' && ch <= '9') {
                map.put(ch - '0', sb.toString());
                sb.setLength(0);
            } else if (ch != ' '){
                sb.append(ch);
            }
        }

        for (String str : map.values()) {
            sb.append(str + " ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
