class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0;i < m;i++) {
            for(int j = 0; j < n;j++) {
                if(i == 0 || i == m-1 || j == 0 || j == n-1) {
                    if(grid[i][j] == 1) {
                        queue.offer(new int[]{i,j});
                    }
                }
            }
        }

        int[][] visited = new int[m][n];

        int[] delta_row = {1, 0, -1, 0};
        int[] delta_col = {0, 1, 0, -1};

        while(!queue.isEmpty()) {

            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            visited[row][col] = 1;

            for(int i = 0;i < 4;i++) {
                int nrow = row+delta_row[i];
                int ncol = col + delta_col[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
                && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    
                    visited[nrow][ncol] = 1;
                    queue.offer(new int[]{nrow,ncol});
                }
            }
        }

        int count = 0;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;

    }
}