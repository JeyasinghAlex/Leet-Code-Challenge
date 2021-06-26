import java.util.ArrayList;
import java.util.List;

public class CombinationOfString {

    public static void main(String[] args) {
        System.out.println(combinationOfString("abcd"));
    }
    public static List<String> combinationOfString(String s) {

        int len = s.length();
        int n = 1 << len;
        List<String> list = new ArrayList<>();
        for (int i = 1; i < n; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, temp = i; temp != 0; ++j, temp >>= 1) {
                if ((temp & 1) == 1) {
                    sb.append(s.charAt(j));
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
}
