import java.util.LinkedList;
import java.util.Queue;

public class JumpGame_VII {

    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length() - 1) != '0')
            return false;

        int maxReach = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){
            int idx = queue.remove();
            if(idx == s.length() - 1)
                return true;
            for(int i = Math.max(idx + minJump, maxReach); i <= Math.min(idx + maxJump, s.length() - 1); i++){
                if(s.charAt(i) == '0'){
                    queue.add(i);
                }
            }
            maxReach = Math.min(idx + maxJump + 1, s.length() - 1);
        }
        return false;

    }
}
