package WeeklyContest_324_18_12_22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class AddEdgesToMakeDegreesOfAllNodesEven {

    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] count = new int[n + 1];
        Set<List<Integer>> set = new HashSet<>();
        for (List<Integer> edge : edges) {
            count[edge.get(0)]++;
            count[edge.get(1)]++;
            set.addAll(List.of(edge, List.of(edge.get(1), edge.get(0))));
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (count[i] % 2 == 1) {
                list.add(i);
            }
        }
        return list.isEmpty()
                || list.size() == 2 && IntStream.range(1, n + 1)
                .anyMatch(v -> !set.contains(List.of(list.get(0), v)) && !set.contains(List.of(list.get(1), v)))
                || list.size() == 4 && (!set.contains(List.of(list.get(0), list.get(1)))
                && !set.contains(List.of(list.get(2), list.get(3)))
                || !set.contains(List.of(list.get(0), list.get(2)))
                && !set.contains(List.of(list.get(1), list.get(3)))
                || !set.contains(List.of(list.get(0), list.get(3)))
                && !set.contains(List.of(list.get(1), list.get(2))));
    }
}
