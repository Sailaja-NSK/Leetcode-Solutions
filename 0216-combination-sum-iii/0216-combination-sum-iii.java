class Solution {
    public void generate(int index,int k,int n,int[] arr,List<List<Integer>> ans,List<Integer> temp) {
        if(temp.size() == k && n == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(index == arr.length) return;

        if(n >= arr[index]) {
            temp.add(arr[index]);
            generate(index+1,k,n-arr[index],arr,ans,temp);
            temp.remove(temp.size()-1);
        }
        generate(index+1,k,n,arr,ans,temp);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[9];
        for(int i = 0;i < 9;i++) {
            arr[i] = i+1;
        }
        generate(0,k,n,arr,ans,new ArrayList<>());
        return ans;
    }
}