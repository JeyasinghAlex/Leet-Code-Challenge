public class NumberOfSubstringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {

        int count = 0;
        int l1 = -1;
        int l2 = -1;
        int l3 = -1;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); ++i) {

            if (s.charAt(i) == 'a') {
                l1 = i;
            } else if (s.charAt(i) == 'b') {
                l2 = i;
            } else if (s.charAt(i) == 'c') {
                l3 = i;
            }

            if (l1 != -1 && l2 != -1 && l3 != -1) {
                min = Math.min(l1, Math.min(l2, l3));
                count += min + 1;
            }
        }
        return count;
    }
}
