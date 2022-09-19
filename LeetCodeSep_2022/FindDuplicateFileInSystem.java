import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {

            String[] values = path.split(" ");

            for (int i = 1; i < values.length; ++i) {
                String[] fileAndContent = values[i].split("\\(");

                String file = fileAndContent[0];
                String content = fileAndContent[1].replace(")","");

                map.putIfAbsent(content, new ArrayList<>());

                String filePath = values[0] + "/" + file;
                map.get(content).add(filePath);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                ans.add(list);
            }
        }
        return ans;
    }
}
