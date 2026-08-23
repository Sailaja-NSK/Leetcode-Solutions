class DisJointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    DisJointSet(int n) {
        for(int i = 0;i <= n;i++) {
            parent.add(i);
            rank.add(0);
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

        if(rank.get(up_u) < rank.get(up_v)) {
            parent.set(up_u,up_v);
        } else if(rank.get(up_u) > rank.get(up_v)) {
            parent.set(up_v,up_u);
        } else {
            parent.set(up_v,up_u);
            rank.set(up_u,rank.get(up_u)+1);
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisJointSet ds = new DisJointSet(n);
        int count = n;

        for(int i = 0;i < n;i++) {
            for(int j = i+1;j < n;j++) {
                if(isConnected[i][j] == 1 && ds.findParent(i) != ds.findParent(j)) {
                    count--;
                    ds.union(i,j);
                }
            }
        }
        return count;
    }
}