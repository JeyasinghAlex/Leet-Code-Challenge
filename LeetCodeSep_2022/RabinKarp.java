import java.util.ArrayList;
import java.util.List;

public class RabinKarp {


    public static List<Integer> stringMatch_1(String str, String pat) {

        int n = pat.length();

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= str.length() - n; ++i) {

            String substr = str.substring(i, n + i);

            if (pat.equals(substr)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
