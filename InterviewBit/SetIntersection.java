package InterviewBit;

import java.util.*;

public class SetIntersection {

    public int setIntersection(int[][] A) {

        int n = A.length;
        Arrays.sort(A, (a, b) ->  a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        List<Integer> ans = new ArrayList<>();

        ans.add(A[0][1] - 1);
        ans.add(A[0][1]);

        for (int i = 1; i < n; ++i) {
            int start = A[i][0];
            int end = A[i][1];
            int size = ans.size();
            int last = ans.get(size -1);
            int secondLast = ans.get(size - 2);

            if (start > last) {
                ans.add(end - 1);
                ans.add(end);
            }
            else if (start == last) {
                ans.add(end);
            }
            else if (start > secondLast) {
                ans.add(end);
            }
        }
        return ans.size();
    }

    public int setIntersection_1(int[][] A) {

        int n = A.length;
        Arrays.sort(A, (a, b) ->  a[1] - b[1]);
        Set<Integer> set = new HashSet<>();

        for (int[] intervel : A) {

            int cnt = 0;
            for (int i = intervel[1]; i >= intervel[0] && cnt < 2; --i) {
                if (set.contains(i)) {
                    ++cnt;
                }

            }

            for (int i = intervel[1]; i >= intervel[0] && cnt < 2; --i) {
                if (!set.contains(i)) {
                    set.add(i);

                    ++cnt;
                }
            }

        }
        //System.out.println(set);
        return set.size();
    }
}
