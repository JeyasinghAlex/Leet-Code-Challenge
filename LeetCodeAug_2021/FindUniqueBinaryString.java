import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            char ch = nums[i].charAt(i) == '0' ? '1' : '0';
            sb.append(ch);
        }
        return sb.toString();
    }

    public String findDifferentBinaryString_1(String[] nums) {

        Set<String> set = new HashSet<>();
        for (String s : nums) {
            set.add(s);
        }

        int n = 1 << nums.length;
        for (int i = 0; i < n; ++i) {
            String binary = countBits(i);
            if (binary.length() == nums.length && !set.contains(binary)) {
                return binary;
            }
        }
        return "0";
    }

    private String countBits(int n) {

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n & 1);
            n >>>= 1;
        }
        return sb.toString();
    }
}
