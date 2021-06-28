public class AddStrings {

    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int cy = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int a = i < 0 ? 0 : num1.charAt(i) - 48;
            int b = j < 0 ? 0 : num2.charAt(j) - 48;
            int c = (a + b + cy) % 10;
            cy = (a + b + cy) / 10;
            sb.append(c);
            --i; --j;
        }
        if (cy != 0) {
            sb.append(cy);
        }
        return sb.reverse().toString();
    }
}
