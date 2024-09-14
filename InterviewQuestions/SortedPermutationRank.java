package InterviewQuestions;

public class SortedPermutationRank {

    private int MOD = 1000003;
    public int findRank(String A) {
        int n=A.length();
        int[] fact =new int[n];
        int[] rank =new int[n];
        int ans=0;
        for(int i = 0; i < n; ++i){
            int count = 0;
            for (int j = i+1; j < n; ++j){
                if(A.charAt(i) > A.charAt(j)){
                    ++count;
                }
            }
            rank[i] = count;
        }
        for(int i = 0; i < n; ++i){
            ans = ans +(rank[i] * factorial(n - 1 - i)) % MOD;
        }
        return (ans + 1) % MOD;
    }

    private int factorial(int i){
        if(i == 1){
            return 1;
        }
        if(i == 0){
            return 1;
        }
        return (i * factorial(i-1)) % MOD;
    }
}
