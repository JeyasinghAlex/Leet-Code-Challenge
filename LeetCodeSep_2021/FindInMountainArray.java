public class FindInMountainArray {

    interface MountainArray {
       public int get(int index);
       public int length();
  }

    public int findInMountainArray(int target, MountainArray arr) {

        int n = arr.length();
        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (arr.get(mid) < arr.get(mid + 1)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        int peek = lo;
        int l = 0;
        int r = peek;
        while (l <= r) {

            int mid = l + r >>> 1;
            if (target > arr.get(mid)) {
                l = mid + 1;
            } else if (target < arr.get(mid)){
                r = mid - 1;
            } else {
                return mid;
            }
        }

        l = peek;
        r = n;
        while (l < r) {
            int mid = l + r >>> 1;
            if (target > arr.get(mid)) {
                r = mid - 1;
            } else if (target < arr.get(mid)){
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
