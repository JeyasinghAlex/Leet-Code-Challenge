package LeetCodeJun_2021;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static final Map<Character, Integer> map ;
    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    public int romanToInt(String s) {

        int result = 0;

        char[] arr = s.toCharArray();
        int last = map.get(arr[arr.length - 1]);

        for (int i = arr.length - 1; i >= 0; --i) {

            if (last <= map.get(arr[i])) {
                result += map.get(arr[i]);
            } else{
                result -= map.get(arr[i]);
            }
            last = map.get(arr[i]);
        }
        return result;

    }
}
