class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max_profit = 0;
        int min_ele = prices[0];
        for(int i = 1;i < n;i++) {
            if(prices[i] < min_ele){
                min_ele = prices[i];
            }
            max_profit = Math.max(max_profit,prices[i]-min_ele);
        }

        return max_profit;
    }
}