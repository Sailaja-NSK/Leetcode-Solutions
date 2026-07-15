class Solution {
    public int f(int idx, int[] nums,int[] dp_arr) {
        if(idx == 0)  return nums[idx];
        if(idx < 0) return 0;

        if(dp_arr[idx] != -1) return dp_arr[idx];

        int pick = nums[idx] + f(idx-2,nums,dp_arr);
        
        int not_pick = 0 + f(idx-1,nums,dp_arr);

        return dp_arr[idx] = Math.max(pick,not_pick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp_arr = new int[n+1];
        Arrays.fill(dp_arr,-1);
        return f(n-1,nums,dp_arr);
    }
}