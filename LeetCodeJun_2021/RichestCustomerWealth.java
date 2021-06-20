public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {

        int max = Integer.MIN_VALUE;
        for (int[] wealth : accounts) {
            int total = 0;
            for (int amount : wealth) {
                total += amount;
            }
            max = Math.max(total, max);
        }
        return max;
    }
}
