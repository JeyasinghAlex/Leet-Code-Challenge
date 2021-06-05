public class BinarySearch {

    public int[] searchRange(int[] nums, int target) {
        int firstPos = lowerBound(nums, target);
        int lastPos = upperBound(nums, target);
        if(firstPos > lastPos) return new int[]{-1, -1};

        return new int[]{firstPos, lastPos};
    }

    private int lowerBound(int[] nums, int target){
        final int N = nums.length;
        int lo = 0, hi = N;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;

            if(target > nums[mid])
                lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }

    private int upperBound(int[] nums, int target){
        final int N = nums.length;
        int lo = 0, hi = N;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;

            if(target < nums[mid])
                hi = mid;
            else
                lo = mid + 1;
        }
        return hi - 1;
    }


    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else {
                index = mid;
                if (isLeft)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return index;
    }
}
