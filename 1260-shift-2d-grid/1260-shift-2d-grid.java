class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;

        k %= total;

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0;i < n;i++) {
            ans.add(new ArrayList<>());
            for(int j = 0;j < m;j++) {
                ans.get(i).add(0);
            }
        }

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                int curr = i * m + j;
                int next = (curr + k ) % total;

                int newRow = next / m;
                int newCol = next % m;

                ans.get(newRow).set(newCol,grid[i][j]);
            }
        }

        return ans;
    }
}