class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i = 0;i < nums.length-k+1;i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i;j < i+k;j++) {
                set.add(nums[j]);
            }
            for(int num : set) {
                mp.put(num,mp.getOrDefault(num,0)+1);
            }
        }

        int res = -1;
        for(int key:mp.keySet()) {
            if(mp.get(key) == 1) {
                res = Math.max(res,key);
            }
        }
        return res;
    }
}