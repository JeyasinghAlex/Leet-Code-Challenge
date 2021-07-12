public class DIStringMatch {

    public int[] diStringMatch(String s) {

        int i = 0;
        int d = s.length();
        int[] perm = new int[d + 1];
        int idx = 0;

        for (char ch : s.toCharArray()) {
            perm[idx++] = ch == 'I' ? i++ : d--;
        }

        perm[idx++] = d;

        return perm;
    }

    public int[] diStringMatch_1(String s) {

        int i = 0;
        int d = s.length();
        int[] perm = new int[d + 1];
        int idx = 0;

        for (int j = 0; j < s.length(); ++j) {

            if (s.charAt(j) == 'I') {
                perm[idx++] = i++;
            } else if (s.charAt(j) == 'D') {
                perm[idx++] = d--;
            }
        }

        perm[idx++] = d;

        return perm;
    }
}
