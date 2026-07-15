class Solution {
    public int f(int idx, int start,int[] nums, int[] dp_arr) {
        if(idx == start) return nums[start];
        if(idx < start) return 0;
        if(dp_arr[idx] != -1) return dp_arr[idx];

        int pick = nums[idx] + f(idx-2,start,nums,dp_arr);
        int not_pick = 0 + f(idx-1,start,nums,dp_arr);

        return dp_arr[idx] = Math.max(pick,not_pick);
    }
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        
        int[] dp_arr1 = new int[n];
        int[] dp_arr2 = new int[n];

        Arrays.fill(dp_arr1,-1);
        Arrays.fill(dp_arr2,-1);

        return Math.max(f(n-2,0,nums,dp_arr1), f(n-1,1,nums,dp_arr2)); 
    }
}