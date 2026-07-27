class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n == 1) return;
        int i = 0,j = 1;
        while(i < n && j < n) {
            if(nums[i] == 0 && nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;

            }else if (nums[i] == 0 && nums[j] == 0) {
                j++;
            } else {
                i++;
                j++;
            }
        }
    }
}