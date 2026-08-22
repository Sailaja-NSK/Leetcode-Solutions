class Solution {
    public boolean checkDivisibility(int n) {
        long sum = 0;
        long product = 1;
        int temp = n;
        while(temp > 0) {
            int rem = temp % 10;
            sum = sum + rem;
            product = product * rem;
            temp = temp / 10;
        }

        long tot_sum = sum + product;

        if(n % (int)tot_sum == 0) return true;
        return false; 
    }
}