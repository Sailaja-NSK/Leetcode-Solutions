class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> mp = new HashMap<>();
        int prefixSum = 0;
        int cnt = 0;

        mp.put(0,1);
        for(int i = 0;i < n;i++){
            prefixSum += nums[i];

            
            int temp = prefixSum - k;
            if(mp.containsKey(temp)){
                cnt += mp.get(temp);
            }

            mp.put(prefixSum,mp.getOrDefault(prefixSum,0)+1);
        }

        return cnt;
    }
}