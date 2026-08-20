class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int lastEle1 = nums[0];
        int lastEle2 = nums[1];
        for(int i = 2;i < n;i++) {
            if(lastEle1 > lastEle2) {
                arr1.add(nums[i]);
                lastEle1 = nums[i];
            } else {
                arr2.add(nums[i]);
                lastEle2 = nums[i];
            }
        }

        int[] ans = new int[n];
        for(int i = 0; i < arr1.size();i++) {
            ans[i] = arr1.get(i);
        }

        for(int j = 0; j < arr2.size();j++) {
            ans[j+arr1.size()] = arr2.get(j);
        }


        return ans;
    }
}