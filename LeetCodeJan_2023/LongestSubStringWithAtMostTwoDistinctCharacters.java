public class LongestSubStringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int[] map = new int[128];
        int counter = 0;
        int start = 0;
        int end = 0;
        int max = 0;

        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] == 0) {
                ++counter;
            }
            map[c1]++;
            ++end;

            while (counter > 2) {
                char c2 = s.charAt(start);
                map[c2]--;
                if (map[c2] == 0) {
                    --counter;
                }
                ++start;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}
