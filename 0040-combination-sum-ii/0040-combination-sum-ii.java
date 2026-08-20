class Solution {
    public void findCombinations(int index,int[] candidates,int target,int n ,List<List<Integer>> ans,List<Integer> temp) {
        
        if(target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index;i < n;i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(target < candidates[i]) break;

            temp.add(candidates[i]);
            findCombinations(i+1,candidates,target-candidates[i],n,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,candidates,target,n,ans,new ArrayList<>());
        return ans;
    }
}