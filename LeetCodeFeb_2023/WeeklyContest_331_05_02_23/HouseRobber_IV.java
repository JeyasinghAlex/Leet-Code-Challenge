package WeeklyContest_331_05_02_23;

public class HouseRobber_IV {

    public int minCapability(int[] nums, int k) {
        int low = 0, high = 1000000001;
        while(high - low > 1){
            int h = high+low>>1;
            int num = 0;
            boolean done = false;
            for(int v : nums){
                if(v <= h && !done){
                    num++;
                    done = true;
                }else if(done){
                    done = false;
                }
            }
            if(num >= k) {
                high = h;
            }else{
                low = h;
            }
        }
        return high;
    }
}
