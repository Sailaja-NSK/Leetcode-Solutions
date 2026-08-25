class DisJointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    DisJointSet(int n) {
        for(int i = 0;i < n;i++) {
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node) {
        if(parent.get(node) == node) {
            return node;
        }
        int up = findParent(parent.get(node));
        parent.set(node,up);
        return parent.get(node);
    }

    public void union(int u,int v) {
        int up_u = findParent(u);
        int up_v = findParent(v);

        if(up_u == up_v) return;

        if(size.get(up_u) < size.get(up_v)) {
            parent.set(up_u,up_v);
            size.set(up_v,size.get(up_u)+size.get(up_v));
        } else {
            parent.set(up_v,up_u);
            size.set(up_u,size.get(up_u)+size.get(up_v));
        }
    }
}
class Solution {
    public boolean isValid(int row,int col,int n) {
        if(row >= 0 && row < n && col >= 0 && col < n) return true;
        return false;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisJointSet ds = new DisJointSet(n*n);
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                int[] di = {-1,1,0,0};
                int[] dj = {0,0,-1,1};
                for(int l = 0;l < 4;l++) {
                    int newRow = di[l]+i;
                    int newCol = dj[l]+j;
                    if(grid[i][j] == 1 && isValid(newRow,newCol,n) && grid[newRow][newCol] == 1) {
                        int rowNo = i * n + j;
                        int adjacentRowNo = newRow * n + newCol;
                        ds.union(rowNo,adjacentRowNo);
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                if(grid[i][j] == 1) continue;
                int[] di = {-1,1,0,0};
                int[] dj = {0,0,-1,1};
                Set<Integer> st = new HashSet<>();
                for(int l = 0;l < 4;l++) {
                    int newRow = di[l]+i;
                    int newCol = dj[l]+j;
                    if(isValid(newRow,newCol,n) && 
                    grid[newRow][newCol] == 1) {
                        int nodeNum = newRow * n + newCol;
                        st.add(ds.findParent(nodeNum));
                    }
                }

                int sizeTotal = 0;
                for(int parent:st) {
                    sizeTotal += ds.size.get(parent);
                }

                ans = Math.max(ans,sizeTotal+1);
            }
        }

        for(int cellNo = 0;cellNo < n*n;cellNo++) {
            ans = Math.max(ans,ds.size.get(ds.findParent(cellNo)));
        }
        return ans;
    }
}