class Solution {
    public int dp(int n , int[] dp_arr) {
        if(n == 0 || n == 1) return 1;
        if(dp_arr[n] != 0) return dp_arr[n];
        return dp_arr[n] = dp(n-1,dp_arr) + dp(n-2,dp_arr);
    }
    public int climbStairs(int n) {
        int[] dp_arr = new int[n+1];
        int ans = dp(n,dp_arr);

        return ans;
    }
}
