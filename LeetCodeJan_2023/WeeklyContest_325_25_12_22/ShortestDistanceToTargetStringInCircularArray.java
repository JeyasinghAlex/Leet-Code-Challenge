package WeeklyContest_325_25_12_22;

public class ShortestDistanceToTargetStringInCircularArray {

        public int closetTarget(String[] words, String target, int startIndex) {
                int n = words.length;
                for (int i = 0; i < n; i++) {
                        if (words[(startIndex + i) % n].equals(target)
                                || words[(startIndex - i + n) % n].equals(target)) {
                                return i;
                        }
                }
                return -1;
        }
}
