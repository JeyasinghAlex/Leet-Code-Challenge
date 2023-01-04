package WeeklyContest_325_25_12_22;

public class Take_K_OfEachCharacterFromLeftAndRight {


    public int takeCharacters(String s, int k) {
        int a = 0;
        int b = 0;
        int c = 0;

        int n = s.length();
        int ans = n;

        for(int i = 0; i < n; ++i){
            if(s.charAt(i) == 'a')
                a++;
            if(s.charAt(i) == 'b')
                b++;
            if(s.charAt(i) == 'c')
                c++;
        }

        if(a < k || b < k || c < k)
            return -1;

        int i = n - 1;
        int j = n - 1;

        while(i >= 0){
            if(s.charAt(i) == 'a')
                a--;
            if(s.charAt(i) == 'b')
                b--;
            if(s.charAt(i) == 'c')
                c--;

            while(a < k || b < k || c < k) {
                if(s.charAt(j) == 'a')
                    a++;
                if(s.charAt(j) == 'b')
                    b++;
                if(s.charAt(j) == 'c')
                    c++;
                j--;
            }
            ans = Math.min(ans, i + n - 1 - j);
            i--;
        }
        return ans;
    }
}
