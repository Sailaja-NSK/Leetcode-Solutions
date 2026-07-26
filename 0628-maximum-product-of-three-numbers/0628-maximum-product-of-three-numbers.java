class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = 0;
        int positive_cnt = 0;
        int negative_cnt = 0;
        for(int num:nums) {
            if(num < 0) negative_cnt++;
            else positive_cnt++;
        }

        if(positive_cnt == 0 || negative_cnt == 0) {
            ans = nums[n-1]*nums[n-2]*nums[n-3];
        } else {
            int temp1 = nums[n-1]*nums[n-2]*nums[n-3]; 
            int temp2 = nums[0]*nums[1]*nums[n-1];
            ans = Math.max(temp1,temp2);
        }

        return ans;
    }
}