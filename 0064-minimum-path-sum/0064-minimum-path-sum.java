class Solution {
    public int f(int i , int j, int[][] grid,int[][] dp) {
        if(i == 0 && j == 0) return grid[i][j];
        if(i < 0 || j < 0 ) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int up = Integer.MAX_VALUE; 
        int left = Integer.MAX_VALUE;
        if(i > 0) {
            up = f(i-1,j,grid,dp) + grid[i][j];
        }
        if(j > 0) {
            left = f(i,j-1,grid,dp) + grid[i][j];
        }
        

        return dp[i][j] = Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) {
            Arrays.fill(dp[i],-1);
        }
        return f(m-1,n-1,grid,dp);
    }
}