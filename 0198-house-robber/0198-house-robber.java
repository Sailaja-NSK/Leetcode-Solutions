class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp_arr = new int[n+1];
        Arrays.fill(dp_arr,-1);

        dp_arr[0] = nums[0];
        for(int i = 1;i < n;i++) {
            int pick = nums[i];
            if(i > 1) pick += dp_arr[i-2];
            int not_pick = 0 + dp_arr[i-1];
            dp_arr[i] = Math.max(pick,not_pick);
        }
        return dp_arr[n-1];
    }
}