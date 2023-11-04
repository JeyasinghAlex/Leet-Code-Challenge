package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * Salesforce:
 */
public class RodCutting {


    /**
     * Given an array with the lengths of various metal rods, repeatedly perform the following:
     * 1. Count the number of rods.
     * 2. Find the rod(s) with the shortest length.
     * 3. Discard any rod of that length.
     * 4. Cut that shortest length from each of the longer rods. These are offcuts.
     * 5. Discard all offcuts. 6. Repeat until there are no more rods.
     *
     * Maintain an array of the numbers of rods at the beginning of each round of actions and return that array.
     * Examples = 4 lengths = [1,1,3,4]
     *
     * - The shortest rods are 1 unit long, so discard them and record their length.
     * - Remove their length, 1 unit, from the longer rods and discard the offcuts.
     * - Now, there are 2 rods, lengths = [2, 3]. Discard the rod of length 2.
     * - Cut 2 from the rod length 3, and discard the offcut.
     * - Now there is only one rod of length 1.
     *
     * It is the shortest, so discard it.
     * Return an array with the number of rods at the start of each turn:[4,2,1].
     * Function Description Complete the function rodOffcut in the editor below.
     *
     * rodOffcut has the following parameter(s):
     * int lengths[n]: the starting lengths of each rod Returns:
     * int[]: the number of rods at the start of each turn Constraints -1 ≤ n ≤ 103 - 1 ≤ lengths[i] ≤ 103, where 0 ≤ i
     *
     */

    public List<Integer> rodOffcut(List<Integer> lengths) {

        int n = lengths.size();
        lengths.sort((a, b) -> a - b);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; ) {
            ans.add(n - i);
            int currVal = lengths.get(i);

            for ( ; i < n && lengths.get(i) == currVal; ++i);

        }
        return ans;
    }
}
