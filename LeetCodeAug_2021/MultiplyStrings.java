public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();
        int[] product = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {

                int idx = i + j + 1;
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                product[idx] += d1 * d2;
            }
        }

        int cy = 0;
        for (int i = product.length - 1; i >= 0; --i) {
            int temp = (product[i] + cy) % 10;
            cy = (product[i] + cy) / 10;
            product[i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < product.length; ++i) {
            if (product[i] != 0 || sb.length() > 0) {
                sb.append(product[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multiply_1(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();
        int[] product = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {

                int p1 = i + j;
                int p2 = i + j + 1;
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                int mul = d1 * d2;
                int sum = mul + product[p2];

                product[p1] += sum / 10;
                product[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < product.length; ++i) {

            if (product[i] != 0 || sb.length() > 0) {
                sb.append(product[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
