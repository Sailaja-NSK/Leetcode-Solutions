class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        
        int aheadBuy = 0, aheadNotBuy = 0;

        for(int idx = n-1;idx >= 0;idx--) {

            int currBuy = Math.max(-prices[idx] + aheadNotBuy, 0+aheadBuy); 
            int currNotBuy = Math.max(prices[idx] + aheadBuy, 0+aheadNotBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}