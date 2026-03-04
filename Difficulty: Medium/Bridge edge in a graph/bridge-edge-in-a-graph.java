class Solution {
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] visited = new int[V];
        int countC = 0;
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(visited,i,adj);
                countC++;
            }
        }
        
        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));
        
        int countR = 0;
        
        for(int i = 0; i < V; i++) visited[i] = 0;
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(visited,i,adj);
                countR++;
            }
        }
        
        return countR > countC;
    }
    
    public void dfs(int[] visited, int node, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        
        for(int neighbor : adj.get(node)){
            if(visited[neighbor] == 0)
            dfs(visited,neighbor,adj);
        }
    }
}