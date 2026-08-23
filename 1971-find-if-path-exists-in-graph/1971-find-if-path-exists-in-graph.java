class Solution {
    public void dfs(int node,List<List<Integer>> adj_list,int[] visited) {
        visited[node] = 1;

        for(int neighbour:adj_list.get(node)) {
            if(visited[neighbour] == 0) {
                dfs(neighbour,adj_list,visited);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] visited = new int[n];
        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            adj_list.add(new ArrayList<>());
        }
        for(int i = 0;i < edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj_list.get(u).add(v);
            adj_list.get(v).add(u);
        }
        dfs(source,adj_list,visited);
        if(visited[destination] == 1) return true;
        return false;
    }
}