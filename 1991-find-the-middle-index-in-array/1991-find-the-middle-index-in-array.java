class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int total_sum = 0;
        for(int ele:nums) {
            total_sum += ele;
        }
        int left_sum = 0;
        for(int i = 0;i < n;i++) {
            int right_sum = total_sum - left_sum - nums[i];

            if(left_sum == right_sum) return i;
            left_sum += nums[i];


        }
        return -1;
    }
}