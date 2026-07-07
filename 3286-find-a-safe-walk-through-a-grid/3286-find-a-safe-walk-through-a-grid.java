class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
          int m = grid.size();
          int n = grid.get(0).size();

          if(grid.get(0).get(0) == 1) {
            health--;
          }

          if(health <= 0) {
            return false;
          }

          int[][] best = new int[m][n];

          for(int i = 0;i < m;i++) {
            Arrays.fill(best[i], -1);
          }

          Queue<int[]> queue = new LinkedList<>();

          queue.offer(new int[]{0,0,health});
          best[0][0] = health;

          int[] delta_row = {-1,1,0,0};
          int[] delta_col = {0,0,-1,1};

          while(!queue.isEmpty()) {
            int[] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];
            int currHealth = cell[2];

            if(row == m-1 && col == n-1) return true;

            for(int i = 0;i < 4;i++) {
                int nrow = row + delta_row[i];
                int ncol = col + delta_col[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                    int newHealth = currHealth;

                    if(grid.get(nrow).get(ncol) == 1) {
                        newHealth--;
                    } 

                    if(newHealth <= 0) continue;

                    if(newHealth > best[nrow][ncol]) {

                        best[nrow][ncol] = newHealth;
                        queue.offer(new int[]{nrow,ncol,newHealth});
                    }
                }
            }
          }
          return false;
    }
}