import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {


        String common = words[0];
        List<Character> list = new ArrayList<>();
        List<Character> com = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        for (char ch : common.toCharArray())
            list.add(ch);

        for (int i = 1; i < words.length; ++i) {

            com = new ArrayList<>();
            for (char ch : words[i].toCharArray()) {

                if (list.contains(ch)) {
                    com.add(ch);
                }
                int idx = list.indexOf(ch);
                if (idx != -1)
                    list.remove(idx);
            }
            list = com;
        }

        for (char ch : com) {
            ans.add(ch + "");
        }
        return ans;
    }
}
