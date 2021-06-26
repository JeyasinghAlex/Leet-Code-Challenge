public class FindNUniqueIntegersSumUpToZero {

    public int[] sumZero(int n) {

        int left = 0;
        int right = n - 1;
        int[] ans = new int[n];
        int temp = 1;
        while (left < right) {
            ans[left++] = temp;
            ans[right--] = -temp;
            ++temp;
        }
        return ans;
    }
}
