class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        
        int[] checkSorted = new int[n];

        for(int i = 0;i < n;++i) {
            int curr = 0;
            for(int index = i;index < n;++index) {
                checkSorted[curr++] = nums[index];
            }

            for(int index = 0;index < i;++index) {
                checkSorted[curr++] = nums[index];
            }

            boolean isSorted = true;
            for(int j = 0;j < n-1;j++) {
                if(checkSorted[j] > checkSorted[j+1]) {
                    isSorted = false;
                    break;
                }
            }

            if(isSorted) {
                return true;
            }
        }

        return false;
    }
}