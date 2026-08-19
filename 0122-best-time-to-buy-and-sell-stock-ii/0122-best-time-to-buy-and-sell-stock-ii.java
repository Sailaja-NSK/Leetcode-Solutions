class Solution {
    public int findMax(int idx,int buy,int[] prices,int n,int profit,int[][] dp) {
        if(idx == n) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        if(buy == 1) {
            profit = Math.max(-prices[idx] + findMax(idx+1,0,prices,n,profit,dp), 
                                0+findMax(idx+1,1,prices,n,profit,dp));
        } else {
            profit = Math.max(prices[idx] + findMax(idx+1,1,prices,n,profit,dp), 
                                0+findMax(idx+1,0,prices,n,profit,dp));
        }
        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;

        int[][] dp = new int[n][2];
        for(int i = 0;i < n;i++) {
            Arrays.fill(dp[i],-1);
        }
        return findMax(0,1,prices,n,profit,dp);
    }
}