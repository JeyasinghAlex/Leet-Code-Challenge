public class K_ConcatenationMaximumSum {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod=1000000007;
        int n=arr.length;
        long presum=0,premax=0,sufsum=0,sufmax=0,cursum=0,curmax=0;
        for(int i=0;i<n;i++){

            // prefix sum
            presum+=arr[i];
            premax=Math.max(premax,presum);

            //suffix sum
            sufsum+=arr[n-1-i];
            sufmax=Math.max(sufmax,sufsum);

            //Kadane's Algorithm
            cursum=Math.max(0,cursum)+arr[i];
            curmax=Math.max(curmax,cursum);
        }
        long max=Math.max(curmax,premax+sufmax+Math.max(0,presum*(k-2)));
        return (int)((k==1?curmax:max)%mod);
    }
}
