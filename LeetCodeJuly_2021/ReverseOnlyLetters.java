public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {

        char[] arr = s.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {

            while (i < s.length() && (arr[i] >= '!' && arr[i] <= '@' || arr[i] >= '[' && arr[i] <= '`')) {
                ++i;
            }

            while (j >= 0 && (arr[j] >= '!' && arr[j] <= '@' || arr[j] >= '[' && arr[j] <= '`')) {
                --j;
            }

            if (i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            ++i; --j;
        }
        return new String(arr);
    }
}
