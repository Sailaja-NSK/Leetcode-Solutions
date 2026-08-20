class Solution {
    public void generateSubsets(int index,int[] nums,int n,
    List<List<Integer>> ans,List<Integer> temp) {
        if(index == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        

        temp.add(nums[index]);
        generateSubsets(index+1,nums,n,ans,temp);
        temp.remove(temp.size()-1);
        generateSubsets(index+1,nums,n,ans,temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(0,nums,n,ans,new ArrayList<>());
        return ans;
    }
}