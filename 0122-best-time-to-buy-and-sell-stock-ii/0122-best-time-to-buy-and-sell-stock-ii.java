class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        

        int[][] dp = new int[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int idx = n-1;idx >= 0;idx--) {
            for(int buy = 0;buy <= 1;buy++) {
                int profit;
                if(buy == 0) {
                    profit = Math.max(-prices[idx] + dp[idx+1][1], 0+dp[idx+1][0]);
                } else {
                    profit = Math.max(prices[idx] + dp[idx+1][0], 0+dp[idx+1][1]);
                }
                dp[idx][buy] = profit;
            }
            
        }
        return dp[0][0];
    }
}