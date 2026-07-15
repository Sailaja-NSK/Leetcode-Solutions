class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp_arr = new int[m][n];
        for(int i = 0;i < m;i++){
            Arrays.fill(dp_arr[i],-1);
        }

        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(i == 0 && j == 0) dp_arr[i][j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = dp_arr[i-1][j];
                    if(j > 0) left = dp_arr[i][j-1];
                    dp_arr[i][j] = up + left;
                }
            }
        }
        return dp_arr[m-1][n-1];
    }
}