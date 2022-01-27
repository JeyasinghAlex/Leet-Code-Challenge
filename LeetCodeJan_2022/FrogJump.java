import java.util.HashMap;
import java.util.Map;

public class FrogJump {

    Map<String, Boolean> map = new HashMap<>();
    public boolean canCross(int[] stones) {
        return canCross(stones, 0, 0);
    }

    public boolean canCross(int[] stones, int pos, int k)
    {
        String key = "pos" + pos + "k" + k;
        if(map.containsKey(key)) return map.get(key);

        for (int i = pos + 1; i < stones.length; i++)
        {
            int gap = stones[i] - stones[pos];
            if (gap < k - 1) continue;
            if (gap > k + 1)
            {
                map.put(key, false);
                return false;
            }
            if (canCross(stones, i, gap))
            {
                map.put(key, true);
                return true;
            }
        }

        map.put(key, pos == stones.length - 1);
        return map.get(key);
    }
}
