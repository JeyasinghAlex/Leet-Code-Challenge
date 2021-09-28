public class SubsequencePatternMatching {

    boolean isSubSequence(String A, String B){

        if (A.length() > B.length()) {
            return false;
        }
        if (A.equals(B)) {
            return true;
        }

        int i = 0;
        int j = 0;
        while (i < A.length() && j < B.length()) {

            if (A.charAt(i) == B.charAt(j)) {
                ++i;
            }
            ++j;
        }
        return i == A.length();
    }
}
