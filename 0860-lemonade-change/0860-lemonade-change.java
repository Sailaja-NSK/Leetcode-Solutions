class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five_bill = 0;
        int ten_bill = 0;
        for(int bill:bills) {
            if(bill == 5) {
                five_bill += 1;
            } else if(bill == 10) {
                ten_bill += 1;
                if(five_bill > 0) five_bill--;
                else return false;
            } else {
                if(ten_bill > 0 && five_bill > 0) {
                    ten_bill--;
                    five_bill--;
                } else if(five_bill >= 3){
                    five_bill -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}