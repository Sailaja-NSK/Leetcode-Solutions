class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;

        if(n == 2) return false;

        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < n-1;i++) {
            int temp = nums[i] + nums[i+1];
            if(set.contains(temp)) return true;
            set.add(temp);
        }

        return false;
    }
}