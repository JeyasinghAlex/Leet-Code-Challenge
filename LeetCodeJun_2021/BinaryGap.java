import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryGap {

    public int binaryGap(int n) {

        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n & 1);
            n >>>= 1;
        }

        Collections.reverse(list);
        int max = 0;
        int count = 1;
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i) == 1) {
                max = Math.max(max, count);
                count = 1;
            } else {
                ++count;
            }
        }
        return max;
    }
}
