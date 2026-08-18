class Solution {
    public void findCombinations(int index,int n,int[] candidates, int target,
                                                List<List<Integer>> ans , List<Integer> temp) {
        if(index == n) {
            if(target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(candidates[index] <= target) {
            temp.add(candidates[index]);
            findCombinations(index,n,candidates,target-candidates[index],ans,temp);
            temp.remove(temp.size()-1);
        }
        findCombinations(index+1,n,candidates,target,ans,temp);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,n,candidates , target,ans,new ArrayList<>());
        return ans;
    }
}