import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_II {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; ++j) {
                int temp = list.get(j) + list.get(j + 1);
                list.set(j, temp);
            }
        }
        return list;
    }
}
