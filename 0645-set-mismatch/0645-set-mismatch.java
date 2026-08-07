class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        long s = (n * (n+1)) / 2;
        long s2 = (n * (n+1) * (2L*n+1) ) / 6;

        long sn = 0;
        long s2n = 0;
        for(int num:nums) {
            sn += num;
            s2n += (long) num * num;
        }

        long val1 = sn- s;
        long val2 = s2n - s2;

        long sumXY = val2 / val1;
        int duplicate = (int)((sumXY + val1) / 2);
        int missing = (int) (duplicate - val1);
        
        ans[0] = duplicate;
        ans[1]= missing;

        return ans;
    } 
}