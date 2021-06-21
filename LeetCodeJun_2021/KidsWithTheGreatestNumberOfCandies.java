import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = Integer.MIN_VALUE;
        List<Boolean> ans = new ArrayList<>();
        for (int a : candies) {
            max = Math.max(max, a);
        }

        for (int i = 0; i < candies.length; ++i) {
            ans.add(candies[i] + extraCandies >= max);

        }
        return ans;
    }
}
