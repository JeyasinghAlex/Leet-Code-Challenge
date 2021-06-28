public class ReverseVowelsOfAString {


    public String reverseVowels(String s) {

        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        while (start < end) {

            while (start < end && !vowels.contains(arr[start] + "")) {
                ++start;
            }

            while (end > start && !vowels.contains(arr[end] + "")) {
                --end;
            }
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }
        return new String(arr);
    }

    public String reverseVowels_(String s) {

        StringBuilder sb  = new StringBuilder();
        String vowels = "";
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' ||ch == 'o' ||ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' ||ch == 'O' ||ch == 'U') {
                sb.append(ch);
            }
        }

        vowels = sb.toString();
        int l = vowels.length() - 1;
        sb = new StringBuilder();
        for (char ch : s.toCharArray()) {

            if (ch == 'a' || ch == 'e' || ch == 'i' ||ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' ||ch == 'O' ||ch == 'U') {
                sb.append(vowels.charAt(l--));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
