public class Maximum69Number {

    public int maximum69Number (int num) {

        int temp = num;
        int step = 1;
        int add = 0;
        while  (temp != 0) {

            int rem = temp % 10;
            if (rem == 6) {
                add = 3 * step;
            }
            temp = temp / 10;
            step *= 10;
        }
        return num + add;
    }

    public int maximum69Number_1 (int num) {

        String s = num + "";
        int ans = 0;
        boolean flag = true;

        for (char ch : s.toCharArray()) {

            if (ch - '0' == 6 && flag) {
                flag = false;
                ans = (ans * 10) + 9;
            } else {
                ans = (ans * 10) + (ch - '0');
            }
        }
        return ans;
    }
}
