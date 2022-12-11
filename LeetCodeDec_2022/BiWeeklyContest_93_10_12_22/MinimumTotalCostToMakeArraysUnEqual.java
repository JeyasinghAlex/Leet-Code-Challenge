package BiWeeklyContest_93_10_12_22;

public class MinimumTotalCostToMakeArraysUnEqual {

    public long minimumTotalCost(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] f = new int[n+1];
        for(int v : nums1)f[v]++;
        for(int v : nums2)f[v]++;
        for(int i = 1;i <= n;i++){
            if(f[i] >= n+1)return -1L;
        }

        boolean[] need = new boolean[n];
        int[] g = new int[n+1];
        int hit = 0;
        long s = 0;
        for(int i = 0;i < n;i++){
            if(nums1[i] == nums2[i]){
                need[i] = true;
                g[nums1[i]]++;
                s += i;
                hit++;
            }
        }
        int z = -1;
        for(int i = 1;i <= n;i++){
            if(g[i] * 2 > hit){
                z = i;
                break;
            }
        }
        if(z == -1)return s;
        for(int i = 0;i < n;i++){
            if(!need[i]){
                if(g[z] * 2 > hit) {
                    if (nums1[i] != z && nums2[i] != z) {
                        s += i;
                        hit++;
                    }
                }
            }
        }
        return s;
    }
}
