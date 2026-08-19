class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        

        int[] ahead = new int[2];
        int[] curr = new int[2];
        

        for(int idx = n-1;idx >= 0;idx--) {
            for(int buy = 0;buy <= 1;buy++) {
                int profit;
                if(buy == 0) {
                    profit = Math.max(-prices[idx] + ahead[1], 0+ahead[0]);
                } else {
                    profit = Math.max(prices[idx] + ahead[0], 0+ahead[1]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
        return curr[0];
    }
}