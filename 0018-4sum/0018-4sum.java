class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0;i < n;i++) {
            for(int j = i+1;j < n;j++) {
                HashSet<Long> st = new HashSet<>();
                for(int k = j+1;k < n;k++) {
                    long sum = nums[i]+nums[j];
                    sum += +nums[k];
                    long fourth = target - sum;
                    if(st.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],(int)fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    st.add((long)nums[k]);
                }
            }
            
        }
        return new ArrayList<>(set);
    }
}