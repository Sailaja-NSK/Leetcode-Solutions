class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        for(int i = 0;i < numCourses;i++) {
            adj_list.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length;i++) {
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            adj_list.get(u).add(v);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0;i < numCourses;i++) {
            for(int neigh:adj_list.get(i)) {
                indegree[neigh]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < numCourses;i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            for(int neigh:adj_list.get(node)) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) queue.offer(neigh);
            }
        }

        
        if(topo.size() < numCourses) {
            return new int[0];
        }
        int[] ans = new int[numCourses];
        for(int i = 0;i < topo.size();i++) {
            ans[i] = topo.get(i);
        }
        return ans;
    }
}