public class FindNumberWithEvenNumberOfDigits {

    int count = 0;
    public int findNumbers(int[] nums) {

        for (int n : nums) {
            count +=  (n + "").length() % 2 == 0 ? 1 : 0;
        }
        return count;
    }
}
