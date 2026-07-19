class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total_sum = 0;
        for(int num:nums) {
            total_sum += num;
        }

        if(total_sum % 2 != 0) return false;

        int target = total_sum / 2;
        boolean[][] dp = new boolean[n][target+1];
        
        for(int i = 0;i < n;i++) {
            dp[i][0] = true;
        }

        if(nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for(int i = 1;i < n;i++) {
            for(int j = 1;j <= target;j++) {

                boolean not_pick = dp[i-1][j];

                boolean pick = false;
                if(j >= nums[i]) {
                    pick = dp[i-1][j-nums[i]];
                }

                dp[i][j] = (pick || not_pick);
            }
        }

        return dp[n-1][target];
    }
}