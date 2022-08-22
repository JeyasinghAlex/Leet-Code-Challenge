public class KthElementOfTwoSortedArrays {

    public long kthElement(int[] arr1, int[] arr2, int n, int m, int k) {

        if (n > m) {
            return kthElement(arr2, arr1, m, n, k);
        }

        int lo = Math.max(0, k - m);
        int hi = Math.min(n, k);

        while (lo <= hi) {

            int cut1 = lo + hi >>> 1;
            int cut2 = k - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];

            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            if ((cut1 + cut2 == k) && (l1 <= r2) && (l2 <= r1)) {
                return Math.max(l1, l2);
            }

            if (l1 > r2) {
                hi = cut1 - 1;
            } else {
                lo = cut1 + 1;
            }
        }
        return 0L;
    }

    public long kthElement_1(int[] arr1, int[] arr2, int n, int m, int k) {

        int i = 0;
        int j = 0;
        int count = 0;


        while (i < n && j < m) {
            ++count;
            if (arr1[i] <= arr2[j]) {
                if (count == k) {
                    return arr1[i];
                }
                ++i;
            } else {
                if (count == k) {
                    return arr2[j];
                }
                ++j;
            }
        }

        while (i < n) {
            ++count;
            if (count == k) {
                return arr1[i];
            }
            ++i;
        }

        while (j < m) {
            ++count;
            if (count == k) {
                return arr2[j];
            }
            ++j;
        }
        return -1;
    }
}
