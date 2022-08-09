public class BinaryTreesWithFactors {

    public int numFactoredBinaryTrees(int[] arr) {

        int n = arr.length;
        int mod = 1000000007;

        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap<>();
        long ans = 1;
        map.put(arr[0], ans);


        for (int i = 1; i < n; ++i) {

            long count = 1;
            for (int j = 0; j < i; ++j) {

                // a / b = c;
                // a = c * b;

                int a = arr[i];
                int b = arr[j];
                int c = a / b;

                if (a % b == 0 && map.containsKey(c)) {
                    count = count + (map.get(c) * map.get(b));
                }
            }
            map.put(arr[i], count);
            ans += count;
        }
        return (int) (ans % mod);
    }
}
