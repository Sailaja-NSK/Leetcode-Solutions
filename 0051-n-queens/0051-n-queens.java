class Solution {
    public void solve(int col,int n,char[][] board,List<List<String>> ans) {
        if(col == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0;i < n;i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int row = 0;row < n;row++) {
            if(isSafe(row,col,board,n)) {
                board[row][col] = 'Q';
                solve(col+1,n,board,ans);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row,int col,char[][] board,int n) {
        for(int i = 0;i < col;i++) {
            if(board[row][i] == 'Q') return false;
        }

        for(int i = row-1,j = col - 1;i >= 0 && j >= 0;i--,j--) {
            if(board[i][j] == 'Q') return false;
        }

        for(int i = row+1,j = col -1;i < n && j >= 0;i++,j--) {
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0;i < n;i++) {
            Arrays.fill(board[i],'.');
        }
        solve(0,n,board,ans);

        return ans;
    }
}