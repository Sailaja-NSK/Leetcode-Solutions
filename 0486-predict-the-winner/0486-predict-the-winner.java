class Solution {
    public int solve(int start,int end, int[] nums,int[][] dp) {
        if(start == end) return nums[start];

        if(dp[start][end] != -1) return dp[start][end];

        int pickLeft = nums[start] - solve(start+1,end,nums,dp);

        int pickRight = nums[end] - solve(start,end-1,nums,dp);


        return dp[start][end] = Math.max(pickLeft,pickRight);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];
        for(int i = 0;i < n;i++) {
            Arrays.fill(dp[i],-1);
        }
        
        return solve(0,nums.length - 1,nums,dp) >= 0;
    }
}