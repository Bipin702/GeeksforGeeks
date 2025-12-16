class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[V];
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
        
            adj.get(v).add(u);
            indegree[u]++;
        }

        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);
            
            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}