class Solution {
    public void generateSubsets(int index,int[] nums,int n,
    List<List<Integer>> ans,List<Integer> temp){
        ans.add(new ArrayList<>(temp));

        for(int i = index;i < n;i++) {
            if(i > index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            generateSubsets(i+1,nums,n,ans,temp);
            temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(0,nums,n,ans,new ArrayList<>());
        return ans;
    }
}