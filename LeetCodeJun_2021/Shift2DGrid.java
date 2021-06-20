import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int row = grid.length;
        int col = grid[0].length;
        int[] arr = new int[row * col];
        int idx = 0;
        k = k % (row * col);

        for (int[] ar : grid) {
            for (int a : ar) {
                arr[idx++] = a;
            }
        }

        int[] rotatedArr = new int[row * col];
        int size = row * col;
        for (int i = 0; i < arr.length; ++i) {
            rotatedArr[(k + i) % size] = arr[i];
        }

        List<Integer> rows = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int count = 0;
        for (int a : rotatedArr) {

            rows.add(a);
            if (++count == col) {
                ans.add(rows);
                rows = new ArrayList<>();
                count = 0;
            }
        }
        return ans;
    }
}
