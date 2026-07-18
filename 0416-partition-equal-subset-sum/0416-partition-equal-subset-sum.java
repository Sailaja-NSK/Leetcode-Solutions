class Solution {
    public boolean f(int index,int target,int[] nums,Boolean[][] dp) {
        if(target == 0) return true;

        if(index == 0) return (nums[0] == target);

        if(dp[index][target] != null) return dp[index][target];

        boolean not_pick = f(index-1,target,nums,dp);

        boolean pick = false;
        if(target >= nums[index]) {
            pick = f(index-1,target-nums[index],nums,dp);
        }

        return dp[index][target] = (pick || not_pick);
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total_sum = 0;
        for(int num:nums) {
            total_sum += num;
        }

        if(total_sum % 2 != 0) return false;

        int target = total_sum / 2;
        Boolean[][] dp = new Boolean[n][target+1];
        return f(n-1,target,nums,dp);
    }
}