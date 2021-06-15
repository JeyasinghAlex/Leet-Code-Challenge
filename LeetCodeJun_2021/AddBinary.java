public class AddBinary {

    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int cy = 0;

        for ( ; i >= 0 || j >= 0; --i, --j) {

            int num1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int num2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = num1 + num2 + cy;
            sb.append(sum % 2);
            cy = sum / 2;
        }
        if (cy != 0) {
            sb.append(cy);
        }
        return sb.reverse().toString();
    }
}
