class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outdegree = new int[n+1];
        int[] indegree = new int[n+1];
        for(int i = 0;i < trust.length;i++) {
            int u = trust[i][0];
            int v = trust[i][1];
            indegree[v]++;
            outdegree[u]++;
        }
        int ans = -1;
        for(int i = 1;i <= n;i++) {
            if(outdegree[i] == 0 && indegree[i] == n-1) ans = i;
        }
        return ans;
    }
}