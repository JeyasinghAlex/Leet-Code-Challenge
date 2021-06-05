package LeetCodeMay_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shift_2DGrid {

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new Shift_2DGrid().shiftGrid(arr, 1));
    }


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int row = grid.length;
        int col = grid[0].length;
        int[] arr = new int[row * col];
        k = k % (row * col);

        int index = 0;
        for (int[] ar : grid) {
            for (int num : ar)
            arr[index++] = num;
        }
        System.out.println(Arrays.toString(arr));
        int[] rotateArr = new int[row * col];
        int len = arr.length;
        for (int i = 0; i < arr.length; ++i) {
            rotateArr[(k + i) % len] = arr[i];
        }
        System.out.println(Arrays.toString(rotateArr));
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length; ++i) {
            ++count;
            list.add(rotateArr[i]);
            if (count == col) {
                ans.add(list);
                count = 0;
                list = new ArrayList<>();
            }
        }
        return ans;
    }
}
