import java.util.ArrayList;
import java.util.List;

public class SubsetSums {

    public List<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        List<Integer> ans = new ArrayList<>();
        recursion(0, 0, arr, ans);
        return ans;
    }

    private void recursion(int start, int sum, List<Integer> list, List<Integer> ans) {

        if (start > list.size()) {
            return;
        }

        ans.add(sum);
        for (int i = start; i < list.size(); ++i) {
            recursion(i + 1, sum + list.get(i), list, ans);
        }
    }
}
