class Solution {
    public void generate(int index,int[] arr,int target,int n,List<List<Integer>> ans,List<Integer> temp) {
        if(index == n) {
            if(target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(arr[index] <= target) {
            temp.add(arr[index]);
            generate(index,arr,target-arr[index],n,ans,temp);
            temp.remove(temp.size()-1);
        }
        generate(index+1,arr,target,n,ans,temp);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,candidates,target,n,ans,new ArrayList<>());
        return ans;
    }
}