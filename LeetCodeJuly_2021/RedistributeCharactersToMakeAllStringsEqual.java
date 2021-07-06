public class RedistributeCharactersToMakeAllStringsEqual {

    public boolean makeEqual(String[] words) {

        int[] frequency = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                frequency[ch - 'a']++;
            }
        }

        for (int n : frequency) {
            if (n % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
