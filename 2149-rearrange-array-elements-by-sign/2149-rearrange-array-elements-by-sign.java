class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pos = 0;
        int neg = 1;
        int[] ans = new int[n];
        int i = 0;
        while(i < n) {
            if(nums[i] > 0) {
                ans[pos] = nums[i];
                pos = pos + 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
            i++;
        }

        return ans;
    }
}