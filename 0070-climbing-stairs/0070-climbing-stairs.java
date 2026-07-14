class Solution {
     public int climbStairs(int n) {
        int[] dp_arr = new int[n+1];

        dp_arr[0] = 1;
        dp_arr[1] = 1;
        for(int i = 2;i <= n;i++) {
            dp_arr[i] = dp_arr[i-1] + dp_arr[i-2];
        }
        return dp_arr[n];
    }
}
