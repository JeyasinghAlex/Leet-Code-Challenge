import java.util.HashMap;
import java.util.Map;

public class ZigzagConversion {

    public String convert(String s, int numRows) {

        int n = s.length();

        if (numRows == 1) {
            return s;
        }

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < numRows; ++i) {
            map.put(i, "");
        }

        boolean incr = true;
        int row = 0;

        for (char ch : s.toCharArray()) {

            map.put(row, map.get(row) + ch);

            if (row == numRows - 1) {
                incr = false;
            }
            if (row == 0) {
                incr = true;
            }

            if (incr) {
                ++row;
            } else {
                --row;
            }
        }

        String ans = "";
        for (int i = 0; i < numRows; ++i) {
            ans += map.get(i);
        }
        return ans;
    }

    public String convert_1(String s, int numRows) {

        int n = s.length();

        if (numRows == 1) {
            return s;
        }

        Map<Integer, String> map = new HashMap<>();

        boolean incr = true;
        int row = 0;

        for (char ch : s.toCharArray()) {

            map.put(row, map.getOrDefault(row, "") + ch);

            if (row == numRows - 1) {
                incr = false;
            }
            if (row == 0) {
                incr = true;
            }

            if (incr) {
                ++row;
            } else {
                --row;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            String temp = map.get(i);
            if (temp != null) {
                ans.append(temp);
            }
        }
        return ans.toString();
    }
}
