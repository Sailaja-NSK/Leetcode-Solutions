class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(m == 1 && n == 1) {
            if(obstacleGrid[m-1][n-1] == 1 ) return 0;
            else return 1;
        }

        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) {
            Arrays.fill(dp[i],-1);
        }

        for(int i = 0;i < m;i++) {
            for(int j = 0; j < n;j++) {
                if(i == 0 && j == 0 && obstacleGrid[i][j] != 1) {
                    dp[i][j] = 1;
                    continue;
                }
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                } 

                int up =  (i > 0) ? dp[i-1][j] : 0;
                int left = (j > 0) ? dp[i][j-1] : 0;

                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }
}