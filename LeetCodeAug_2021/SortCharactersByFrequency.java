import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        int[] count = new int[128];
        char[] chars = new char[128];
        for (char ch : s.toCharArray()) {
            ++count[ch];
            chars[ch] = ch;
        }

        for (int i = 1; i < 128; ++i) {

            int val = count[i];
            char ch = chars[i];
            int hole = i;

            while (hole > 0 && count[hole - 1] < val) {
                count[hole] = count[hole - 1];
                chars[hole] = chars[hole - 1];
                hole--;
            }
            count[hole] = val;
            chars[hole] = ch;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; ++i) {
            while (count[i]-- > 0) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public String frequencySort_1(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int count = map.getOrDefault(ch, 0) + 1;
            map.put(ch, count);
        }

        List<Character>[] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int val = map.get(key);
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; --i) {

            if (bucket[i] != null) {
                for (char ch : bucket[i]) {
                    for (int j = 0; j < i; ++j) {
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
}
