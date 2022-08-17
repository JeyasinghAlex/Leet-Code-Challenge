import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {


    public String getPermutation(int n, int k) {

        List<Integer> list = new ArrayList<>();

        int fact = 1;

        for (int i = 1; i < n; ++i) {
            fact = fact * i;
            list.add(i);
        }
        list.add(n);

        String ans = "";
        k = k - 1;

        while (true) {

            ans += list.get(k / fact);
            list.remove(k / fact);

            if (list.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / list.size();
        }
        return ans;
    }


    private int k;
    public String getPermutation_1(int n, int k) {

        this.k = k;
        boolean[] visited = new boolean[n + 1];

        int fat = 1;

        int temp = n;
        while (temp > 0) {
            fat *= temp;
            --temp;
        }

        int perPart = fat / n;

        if (k % perPart == 0) {
            --k;
        }

        int part = k / n;

        this.k = part;

        return recursion(part, visited, n, "");

    }

    private String recursion(int start, boolean[] visited, int n, String s) {

        if (s.length() == n) {
            --k;

            if (k == 0) {
                return s;
            }
        }


        for (int i = start; i <= n; ++i) {

            if (!visited[i]) {
                visited[i] = true;
                String seq = recursion(i, visited, n, s + i);
                if (seq.length() > 0) {
                    return seq;
                }
                visited[i] = false;
            }
        }
        return "";
    }
}
