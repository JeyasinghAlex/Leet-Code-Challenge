import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {

    public String[] findOcurrences(String text, String first, String second) {

        List<String> list = new ArrayList<>();
        String[] arr = text.split(" ");
        for (int i = 2; i < arr.length; ++i) {

            if (arr[i - 2].equals(first) && arr[i - 1].equals(second)) {
                list.add(arr[i]);
            }
        }
        return list.toArray(new String[]{});
    }

    public String[] findOcurrences_1(String text, String first, String second) {

        List<String> list = new ArrayList<>();
        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length - 1; ++i) {

            if (arr[i].equals(first) && arr[i + 1].equals(second) && i < arr.length - 2) {
                list.add(arr[i + 2]);
            }
        }

        String[] ans = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            ans[idx++] = s;
        }
        return ans;
    }
}
