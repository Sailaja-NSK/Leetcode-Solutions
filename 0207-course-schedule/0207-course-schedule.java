class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        for(int i = 0;i < numCourses;i++) {
            adj_list.add(new ArrayList<>());
        }
        for(int i = 0;i < prerequisites.length;i++) {
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            adj_list.get(u).add(v);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0;i < numCourses;i++) {
            for(int neighbour:adj_list.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < numCourses;i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for(int neighbour:adj_list.get(node)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) queue.offer(neighbour);
            }
        }

        return count == numCourses ? true : false;
    }
}