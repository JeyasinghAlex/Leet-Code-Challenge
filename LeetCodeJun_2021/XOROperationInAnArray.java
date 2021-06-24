public class XOROperationInAnArray {

    public int xorOperation(int n, int start) {
        int[] arr = new int[n + 1];
        int xor = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = start + (2 * i);
            xor ^= arr[i];
        }
        return xor;
    }
}
