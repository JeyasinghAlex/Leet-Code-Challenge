import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagramsUsingPrimeNumbers(String[] strs) {

        List<List<String>> ans = new ArrayList<>();
        Map<Long, List<String>> map = new HashMap<>();
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for (String s : strs) {
            Long key = getKey(s, primes);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        for (List<String> list : map.values()) {
            ans.add(list);
        }
        return ans;
    }


    private long getKey(String s, int[] primes) {

        int mod = 1_000_000_007;
        long key = 1L;

        for (char ch : s.toCharArray()) {
            key = key * primes[ch - 'a'] % mod;
        }
        return key;
    }

    public List<List<String>> groupAnagramsUsingCount(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; ++i) {
            String temp = sort(strs[i]);
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String str) {

        int[] count = new int[26];
        for (char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            while (count[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
