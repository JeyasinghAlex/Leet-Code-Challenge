package WeeklyContest_323_11_12_22;

public class DesignMemoryAllocator {

    int[] m;
    int[] ft;

    public int sumFenwick(int[] ft, int i)
    {
        int sum = 0;
        for(i++;i > 0;i -= i&-i)sum += ft[i];
        return sum;
    }

    public void addFenwick(int[] ft, int i, int v)
    {
        if(v == 0 || i < 0)return;
        int n = ft.length;
        for(i++;i < n;i += i&-i)ft[i] += v;
    }

    public DesignMemoryAllocator(int n) {
        m = new int[n];
        ft = new int[n+5];
    }

    public int allocate(int size, int mID) {
        int n = m.length;
        for(int i = 0;i < n-size+1;i++){
            if(sumFenwick(ft, i+size-1) - sumFenwick(ft, i-1) == 0){
                for(int j = i;j < i+size;j++){
                    m[j] = mID;
                    addFenwick(ft, j, 1);
                }
                return i;
            }
        }
        return -1;
    }

    public int free(int mID) {
        int ret = 0;
        for(int i = 0;i < m.length;i++){
            if(m[i] == mID){
                m[i] = 0;
                addFenwick(ft, i, -1);
                ret++;
            }
        }
        return ret;
    }
}
