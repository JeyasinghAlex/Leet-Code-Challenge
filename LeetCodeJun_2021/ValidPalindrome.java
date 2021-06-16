public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        int i = 0;

        String temp = "";
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {

            if (ch >= 65 && ch <= 90) {
                sb.append((char) (ch + 32));
            }
            if (ch >= 97 && ch <= 122 || ch >= 48 && ch <= 57 ) {
                sb.append(ch);
            }
        }

        temp = sb.toString();
        int j = temp.length() - 1;

        while (i < j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
