public class LargestNumber {

    public String largestNumber(int[] nums) {

        long sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum == 0) {
            return "0";
        }

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {

                long num1 = convertNumber("" + nums[i] + nums[j]);
                long num2 = convertNumber("" + nums[j] + nums[i]);
                if (num1 < num2) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : nums) {
            sb.append(n);
        }
        return sb.toString();
    }

    private long convertNumber(String s) {

        long num = 0;
        for (int i = 0; i < s.length(); ++i) {
            num = (num * 10) + s.charAt(i) - '0';
        }
        return num;
    }
}
