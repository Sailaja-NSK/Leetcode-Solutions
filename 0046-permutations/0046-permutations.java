class Solution {
    public void generatePermutations(int index,int[] nums,int n,List<List<Integer>> ans) {
        if(index == n) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i < n;i++) {
                temp.add(nums[i]);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index;i < n;i++) {
            swap(index,i,nums);
            generatePermutations(index+1,nums,n,ans);
            swap(index,i,nums);
        }
    }

    public void swap(int index1,int index2,int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        generatePermutations(0,nums,n,ans);
        return ans;
    }
}