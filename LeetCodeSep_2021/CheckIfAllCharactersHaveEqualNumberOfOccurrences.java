public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {

    public boolean areOccurrencesEqual(String s) {

        int[] freq = new int[26];

        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }

        int prev = freq[s.charAt(0) - 'a'];

        for(int num: freq){
            if(num != 0 && num != prev){
                return false;
            }
        }
        return true;
    }
}
