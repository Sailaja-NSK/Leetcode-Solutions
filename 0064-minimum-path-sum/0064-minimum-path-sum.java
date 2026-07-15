class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) {
            Arrays.fill(dp[i],-1);
        }
        
        dp[0][0] = grid[0][0];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        for(int i = 0;i < m;i++) {
            for(int j = 0; j < n;j++) {

                if(i == 0 && j == 0) continue;
                up = (i > 0) ? dp[i-1][j] + grid[i][j] : Integer.MAX_VALUE;
                left =  (j > 0) ? dp[i][j-1] + grid[i][j] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(up,left);
            }
        }
        return dp[m-1][n-1];
    }
}