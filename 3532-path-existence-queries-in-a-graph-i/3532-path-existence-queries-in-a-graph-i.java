class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] root = new int[nums.length];
        root[0] = 0;
        for(int i = 1;i < nums.length;i++){
            root[i] = ((nums[i] - nums[i-1]) <= maxDiff) ? root[i-1] : i;
        }

        for(int i = 0;i < queries.length;i++) {
            ans[i] = root[queries[i][0]] == root[queries[i][1]];
        }

        return ans;
    }
}