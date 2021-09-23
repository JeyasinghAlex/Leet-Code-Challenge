public class SumOfBeautyOfAllSubstrings {

    public int beautySum(String s) {

        int beauty = 0;
        for (int i = 0; i < s.length(); ++i) {

            int[] count = new int[26];
            for (int j = i; j < s.length(); ++j) {

                char ch = s.charAt(j);
                ++count[ch - 'a'];
                beauty += maxCount(count) - minCount(count);

            }
        }
        return beauty;
    }

    private int minCount(int[] count) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; ++i) {

            if (count[i] != 0) {
                min = Math.min(min, count[i]);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private int maxCount(int[] count) {

        int max = 0;
        for (int i = 0; i < 26; ++i) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
}
