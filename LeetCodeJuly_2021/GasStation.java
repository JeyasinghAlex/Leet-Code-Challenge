public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total = 0;
        int subSum = 0;
        int idx = 0;
        for (int i = 0; i < gas.length; ++i) {
            total += gas[i] - cost[i];
            subSum += gas[i] - cost[i];
            if (subSum < 0) {
                idx = i + 1;
                subSum = 0;
            }
        }
        return (total >= 0) ? idx : -1;
    }
}
