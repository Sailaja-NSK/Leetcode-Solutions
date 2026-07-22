class Solution {
    public int minJumps(int ind,int n,int[] nums,int[] dp){
        if(ind >= n-1) return 0;
        if(nums[ind] == 0) return Integer.MAX_VALUE;
        int minStep = Integer.MAX_VALUE;
        
        if(dp[ind] != -1) return dp[ind];
        for(int jump = 1;jump <= nums[ind];jump++) {
            int subResult = minJumps(ind + jump,n,nums,dp);
            if (subResult != Integer.MAX_VALUE) {
                minStep = Math.min(minStep, 1 + subResult);
            }
        }
        return dp[ind] = minStep;
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return  minJumps(0,n,nums,dp);
    }
}