public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            if (i < ransomNote.length()) {
                freq[ransomNote.charAt(i) - 'a']++;
            }
            freq[magazine.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; ++i) {
            if (freq[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
