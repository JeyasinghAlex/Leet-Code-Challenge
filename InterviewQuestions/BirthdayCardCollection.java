package InterviewQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Paypal
 */
public class BirthdayCardCollection {

    public static List<Integer> hackerCards(List<Integer> collection, int d) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int c : collection)
            set.add(c);

        for (int i = 1; d - i >= 0; ++i) {
            if (!set.contains(i)) {
                ans.add(i);
                d -= i;
            }
        }

        return ans;
    }
    //Time complexity : O(d) --> (nlogn + nlogn) (Binary search)
    //spACE: o(d)
}
