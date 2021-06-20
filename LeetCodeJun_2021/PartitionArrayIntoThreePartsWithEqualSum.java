public class PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum(int[] arr) {

        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        if (sum % 3 != 0) {
            return false;
        }

        int target = sum / 3;
        sum = 0;
        int count = 0;
        for (int a : arr) {
            sum += a;
            if (sum == target) {
                sum = 0;
                if (++count == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
