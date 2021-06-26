public class ComplementOfBasTenInteger {

    public int bitwiseComplement(int n) {
        int log = (int) (Math.log(n) / Math.log(2));
        log += 1;
        int bitMas = (1 << log);
        bitMas -= 1;
        return bitMas ^ n;
    }
}
