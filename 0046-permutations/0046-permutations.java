class Solution {
    public void generatePermutations(int index,int[] nums,int n,
    List<List<Integer>> ans,List<Integer> temp,int[] mp) {

        if(temp.size() == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0;i < n;i++) {
            if(mp[i] != 1) {
                mp[i] = 1;
                temp.add(nums[i]);
                generatePermutations(i+1,nums,n,ans,temp,mp);
                temp.remove(temp.size()-1);
                mp[i] = 0;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int[] mp = new int[n];
        Arrays.fill(mp,0);
        generatePermutations(0,nums,n,ans,new ArrayList<>(),mp);
        return ans;
    }
}