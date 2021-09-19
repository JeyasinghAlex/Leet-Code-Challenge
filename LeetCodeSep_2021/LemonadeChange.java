public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        for (int bill : bills) {

            if (bill == 5) {
                ++five;
            } else if (bill == 10) {
                ++ten;
                --five;
            } else if (ten > 0){
                --ten;
                --five;
            } else {
                five -= 3;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean lemonadeChange_1(int[] bills) {

        if (bills[0] != 5) {
            return false;
        }
        int five = 0;
        int ten = 0;
        int twenty = 0;
        int count = 0;
        for (int bill : bills) {

            int balance = bill - 5;
            if (balance >= 20 && twenty > 0) {
                count = balance / 20;
                balance -= count * 20;
                twenty -= count;
            }
            if (balance >= 10 && ten > 0) {
                count = balance / 10;
                balance -= count * 10;
                ten -= count;
            }
            if (balance >= 5 && five > 0) {
                count = balance / 5;
                balance -= count * 5;
                five -= count;
            }

            if (five < 0 || ten < 0 || twenty < 0) {
                return false;
            }

            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ++ten;
            } else {
                ++twenty;
            }
            if (balance != 0) {
                return false;
            }
        }
        return true;
    }
}
