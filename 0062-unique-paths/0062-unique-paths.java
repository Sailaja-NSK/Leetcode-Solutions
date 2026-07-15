class Solution {
    public int f(int i, int j,int[][] dp_arr) {
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp_arr[i][j] != -1) return dp_arr[i][j];

        int up = f(i-1,j,dp_arr);
        int left = f(i,j-1,dp_arr);

        return dp_arr[i][j] = up+left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp_arr = new int[m][n];
        for(int i = 0;i < m;i++){
            Arrays.fill(dp_arr[i],-1);
        }
       
        return f(m-1,n-1,dp_arr);
    }
}