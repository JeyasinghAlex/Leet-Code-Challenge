import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generatee(5));
    }


    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        List<Integer> currRow = new ArrayList<>();
        currRow.add(1);
        result.add(currRow);
        for (int i = 1; i < numRows; ++i) {
            currRow = new ArrayList<>();
            List<Integer> preRow = result.get(i - 1);
            currRow.add(1);
            for (int j = 1; j < preRow.size(); ++j) {
                currRow.add(preRow.get(j -1) + preRow.get(j));
            }
            currRow.add(1);
            result.add(currRow);
        }
        return  result;
    }

    public List<List<Integer>> generatee(int numRows)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; ++j) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            result.add(new ArrayList<>(row));
        }
        return result;
    }
}