public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {

        int lo = 0;
        int hi = letters.length - 1;
        if (target >= letters[hi]) {
            return letters[lo];
        }

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target < letters[mid]) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return letters[lo];
    }
}
