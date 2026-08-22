class Solution {
    public void dfs(int node,int[][] matrix,int[] visited,int n) {
        visited[node] = 1;
        for(int i = 0;i < n;i++) {
            if(matrix[node][i] == 1 && visited[i] == 0){
                dfs(i,matrix,visited,n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        int[] visited = new int[n];
        for(int i = 0;i < n;i++) {
            if(visited[i] == 0 ){
                count++;
                dfs(i,isConnected,visited,n);
            }
        }
        return count;
    }
}