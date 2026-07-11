class Solution {

    int vertices;
    int edgesCount; 

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;
        vertices++;

        for (int neighbour : adj.get(node)) {
            edgesCount++;

            if (visited[neighbour] == 0) {
                dfs(neighbour, adj, visited);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i < n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }

        int[] visited = new int[n];
        int completeComponents = 0;

        for(int i = 0;i < n;i++) {
            if(visited[i] == 0) {
                vertices = 0;
                edgesCount = 0;


                dfs(i,adj,visited);
                int actualEdges = edgesCount / 2;

                if(actualEdges == (vertices * (vertices - 1)) / 2) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }
}