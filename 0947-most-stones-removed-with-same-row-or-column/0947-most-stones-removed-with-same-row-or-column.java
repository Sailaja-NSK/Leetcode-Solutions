class DisJointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    DisJointSet(int n) {
        for(int i = 0;i <= n;i++) {
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
            size.set(up_v,size.get(up_v)+size.get(up_u));
        } else {
            parent.set(up_v,up_u);
            size.set(up_u,size.get(up_u)+size.get(up_v));
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0;i < n;i++) {
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }
        DisJointSet ds = new DisJointSet(maxRow+maxCol+1);
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i < n;i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.union(nodeRow,nodeCol);
            mp.put(nodeRow,1);
            mp.put(nodeCol,1);
        }
        int cnt = 0;
        for(Map.Entry<Integer,Integer> it:mp.entrySet()) {
            if(ds.findParent(it.getKey()) == it.getKey()) cnt++;
        }
        return n - cnt;
    }
}