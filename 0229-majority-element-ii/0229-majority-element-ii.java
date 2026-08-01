class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        int mini = (n/3) + 1;
        for(int i = 0;i < n;i++) {
            mp.put(nums[i],mp.getOrDefault(nums[i], 0)+1);

            if(mp.get(nums[i]) == mini) {
                ans.add(nums[i]);
            }

            if(ans.size() == 2) {
                break;
            }

        }
        return ans;
    }
}