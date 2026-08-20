class Solution {
    public void generateSubsets(int index,int[] nums,int n,
    Set<List<Integer>> ans,List<Integer> temp) {
        if(index == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        generateSubsets(index+1,nums,n,ans,temp);
        temp.remove(temp.size()-1);
        generateSubsets(index+1,nums,n,ans,temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        generateSubsets(0,nums,n,ans,new ArrayList<>());
        return new ArrayList<>(ans);
    }
}