public class CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        int i = 0, j = 0;
        while (i < word1.length || j < word2.length) {

            if (i < word1.length){
                s1.append(word1[i++]);
            }
            if (j < word2.length) {
                s2.append(word2[j++]);
            }
        }
        return s1.toString().equals(s2.toString());
    }
}
