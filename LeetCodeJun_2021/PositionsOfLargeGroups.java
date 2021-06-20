import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i) {
            List<Integer> list = new ArrayList<>();
            int count = 0;
            char ch = s.charAt(i);
            int st = i;
            while (i < s.length() && ch == s.charAt(i)){
                ++count;
                ++i;
            }
            --i;
            if (count >= 3) {
                ans.add(Arrays.asList(st, i));
            }
        }
        return ans;
    }
}
