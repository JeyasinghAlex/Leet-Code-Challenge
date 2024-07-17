package InterviewBit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeros {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < a.size(); ++i) {
            List<Integer> list = a.get(i);
            for (int j = 0; j < list.size(); ++j) {

                if (list.get(j) == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < a.size(); ++i) {
            List<Integer> list = a.get(i);
            for (int j = 0; j < list.size(); ++j) {

                if (row.contains(i) || col.contains(j)) {
                    list.set(j, 0);
                }
            }
        }
    }
}
