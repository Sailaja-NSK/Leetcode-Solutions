class Solution {

    public void bfs(int srow,int scol,int m ,int n,char[][] grid,int[][] visited) {
        visited[srow][scol] = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{srow,scol});

        int[] delta_row = {-1,0,1,0};
        int[] delta_col = {0,-1,0,1};

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];

            for(int i = 0;i < 4;i++) {
                int nrow = row + delta_row[i];
                int ncol = col + delta_col[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && 
                visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                    visited[nrow][ncol] = 1;
                    queue.offer(new int[]{nrow,ncol});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        int[][] visited = new int[m][n];
        
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(grid[i][j] == '1' && visited[i][j] == 0) {
                    count++;
                    bfs(i,j,m,n,grid,visited);
                }
            }
         }
          return count;
    }
}