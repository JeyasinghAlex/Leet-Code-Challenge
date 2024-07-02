package InterviewBit;

import java.util.List;

public class GasStation {

    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {

        int index = 0;
        int gas = 0;
        int total = 0;
        for (int i = 0; i < A.size(); ++i) {
            total += A.get(i) - B.get(i);
            gas += A.get(i) - B.get(i);

            if (gas < 0) {
                index = i + 1;
                gas = 0;
            }
        }

        return total >= 0 ? index : -1;
    }
}
