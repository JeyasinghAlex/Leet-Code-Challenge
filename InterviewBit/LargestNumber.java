package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    public String largestNumber(final int[] A) {

        int n = A.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(String.valueOf(A[i]));
        }

        Collections.sort(list, new MyCompare());

        int i = 0;
        while (i < n && list.get(i).equals("0"))
            ++i;

        if (i == n)
            return "0";

        StringBuilder sb = new StringBuilder();
        for ( ; i < n; ++i) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    class MyCompare implements Comparator<String> {

        public int compare(String a, String b) {
            String str = a + b;
            String str1 = b + a;

            return str1.compareTo(str);
        }
    }
}
