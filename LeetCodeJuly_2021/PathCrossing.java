import java.util.HashSet;
import java.util.Set;

public class PathCrossing {

    public boolean isPathCrossing(String path) {

        int x = 0;
        int y = 0;
        Set<String> points = new HashSet<>();

        points.add("(0,0)");
        for (char d : path.toCharArray()) {

            if (d == 'N')
                ++y;
            else if (d == 'S')
                --y;
            else if (d == 'E')
                ++x;
            else if (d == 'W')
                --x;

            String point = "(" + x + "," + y + ")";
            if (points.contains(point)) {
                return true;
            }
            points.add(point);

        }
        return false;
    }
}
