import java.util.*;

public class TheSkylineProblem {

    private class Node {
        private int x, y;
        private boolean isStart;
        public Node () { }
        public Node(int x, int y, boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Node> buildingDetails = new ArrayList<>(buildings.length * 2);
        for (int[] buildingPlan : buildings) {
            int start = buildingPlan[0], end = buildingPlan[1], height = buildingPlan[2];
            Node startNode = new Node(start, height, true);
            Node endNode = new Node (end, height, false);
            buildingDetails.add(startNode);
            buildingDetails.add(endNode);
        }

        Collections.sort(buildingDetails, (a, b) -> {
            if (a.x != b.x) return a.x - b.x;
            else {
                return (a.isStart ? -a.y : a.y ) - (b.isStart ? -b.y : b.y);
            }
        });

        List<List<Integer>> result = new ArrayList<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);
        for (int i = 0; i < buildingDetails.size(); i++) {
            Node curr = buildingDetails.get(i);
            if (curr.isStart) {
                if (curr.y > maxHeap.peek()) {
                    result.add(Arrays.asList(curr.x, curr.y));
                }
                maxHeap.add(curr.y);
            } else {
                int oldMax = maxHeap.peek();
                maxHeap.remove(curr.y);
                if (oldMax != maxHeap.peek()) {
                    result.add(Arrays.asList(curr.x, maxHeap.peek()));
                }
            }
        }

        return result;
    }
}
