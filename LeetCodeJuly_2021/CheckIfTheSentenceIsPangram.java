public class CheckIfTheSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {

        int seen = 0;
        for (char ch : sentence.toCharArray()) {
            int temp = ch - 'a';
            seen = seen | (1 << temp);
        }

        return seen == (1 << 26) - 1;
    }

    public boolean checkIfPangram_1(String sentence) {

        boolean[] arr = new boolean[26];
        for (char ch : sentence.toCharArray()) {
            arr[ch - 'a'] = true;
        }

        for (boolean bool : arr) {
            if(!bool) {
                return false;
            }
        }
        return true;
    }
}
