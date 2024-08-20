package InterviewBit;
import java.util.*;

public class RearrangeArray {

    public void arrange(ArrayList<Integer> a) {

        int n = a.size();

        for (int i = 0; i < n; ++i) {
            int val = a.get(i);
            int indexVal = a.get(val);
            int modifiedValue = ((indexVal % n) * n) + val;
            a.set(i, modifiedValue);
        }

        for (int i = 0; i < n; ++i) {
            int val = a.get(i);
            int actualVal = val / n;
            a.set(i, actualVal);
        }
    }

    public void arrange_1(ArrayList<Integer> a) {

        int n = a.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(i, a.get(i));
        }

        for (int i = 0; i < n; ++i) {
            a.set(i, map.get(map.get(i)));
        }
    }
}
