class Solution {
    public int f(int i,int j1,int j2,int r,int c,int[][] grid,int[][][] dp) {

        if(j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) return Integer.MIN_VALUE;

        if(i == r-1) {
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int maxi = Integer.MIN_VALUE;
        for(int dj1 = -1;dj1 <= 1;dj1++) {
            for(int dj2 = -1;dj2 <= 1;dj2++) {
                if(j1 == j2) {
                    maxi = Math.max(grid[i][j1]+f(i+1,j1+dj1,j2+dj2,r,c,grid,dp),maxi);
                }else {
                    maxi = Math.max(grid[i][j2]+grid[i][j1]+
                    f(i+1,j1+dj1,j2+dj2,r,c,grid,dp),maxi);
                }
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp = new int[r][c][c];
        for(int i = 0;i < r;i++) {
            for(int j = 0;j < c;j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return f(0,0,c-1,r,c,grid,dp);
    }
}