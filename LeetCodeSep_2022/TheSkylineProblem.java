import java.util.*;

public class TheSkylineProblem {


    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();

        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }

        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        Queue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);
        qu.offer(0);
        int prev = 0;

        for (int[] h : heights) {

            if (h[1] < 0) {
                qu.offer(-h[1]);
            }
            else {
                qu.remove(h[1]);
            }
            int curr = qu.peek();
            if (prev != curr) {
                ans.add(Arrays.asList(h[0], curr));
                prev = curr;
            }
        }
        return ans;
    }


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

    public List<List<Integer>> getSkyline_1(int[][] buildings) {
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
