class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length ;
        int[] ans = new int[2];
        for(int i = 1;i <= n;i++) {
            int cnt = 0;
            for(int j = 0;j < n;j++) {
                if(i == nums[j]) {
                    cnt++;
                }
            }
            if(cnt == 2) ans[0] = i;
            if(cnt == 0) ans[1] = i;
        }
        return ans;
    }
}