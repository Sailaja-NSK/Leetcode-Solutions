class Solution {
    public int solve(int start,int end, int[] nums) {
        if(start == end) return nums[start];

        int pickLeft = nums[start] - solve(start+1,end,nums);

        int pickRight = nums[end] - solve(start,end-1,nums);


        return Math.max(pickLeft,pickRight);
    }
    public boolean predictTheWinner(int[] nums) {
        
        return solve(0,nums.length - 1,nums) >= 0;
    }
}