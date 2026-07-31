class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int ele = 0;
        for(int i = 0;i < n;i++){
            if(cnt == 0) {
                cnt = 1;
                ele = nums[i];
            } else {
                if(nums[i] == ele) cnt++;
                else cnt--;
            }
        }

        return ele;
    }
}