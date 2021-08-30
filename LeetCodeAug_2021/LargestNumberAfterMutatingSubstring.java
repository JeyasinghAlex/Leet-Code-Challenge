public class LargestNumberAfterMutatingSubstring {

    public String maximumNumber(String num, int[] change) {

        char[] temp = num.toCharArray();
        boolean flag = false;
        for (int i = 0; i < num.length(); ++i) {
            int d =temp[i] - '0';
            if (change[d] > d) {
                temp[i] = (char) (change[d] + '0');
                flag = true;
            } else if (d != change[d]) {
                if (flag) {
                    break;
                }
            }
        }
        return new String(temp);
    }
}