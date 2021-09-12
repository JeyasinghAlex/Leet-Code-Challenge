package weekly_12;

public class ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {

        char[] arr = word.toCharArray();
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == ch) {
                reverse(arr, 0, i);
                return new String(arr);
            }
        }
        return word;
    }

    private void reverse(char[] arr, int start, int end) {

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
