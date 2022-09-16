public class FindOriginalArrayFromDoubledArray {

    public int[] findOriginalArray(int[] changed) {

        int n = changed.length;

        if (n % 2 == 1) {
            return new int[]{};
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, changed[i]);
        }

        int[] freq = new int[max + 1];

        for (int num : changed) {
            freq[num]++;
        }

        if (freq[0] % 2 == 1) {
            return new int[]{};
        }

        int[] ans = new int[n / 2];

        fill(0, freq[0] / 2, ans);

        for (int i = 1; i <= max / 2; ++i) {
            if (freq[i * 2] < freq[i]) {
                return new int[]{};
            }

            freq[i * 2] -= freq[i];

            fill(i, freq[i], ans);
        }
        return idx != ans.length ? new int[]{} : ans;
    }

    int idx = 0;
    private void fill(int num, int count, int[] ans) {
        while (count-- > 0) {
            ans[idx++] = num;
        }
    }
}
