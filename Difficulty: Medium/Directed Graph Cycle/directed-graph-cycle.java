class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] row : edges){
            int u = row[0];
            int v = row[1];
            adj.get(u).add(v);
        }
        
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        
        for(int i = 0; i < V; i++){
            if(dfs(i,visited,pathVisited,adj)) return true;
        }
        return false;
    }
    
    public boolean dfs(int node, int[] visited, int[] pathVisited,ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        pathVisited[node] = 1;
        
        for(int neighbor : adj.get(node)){
            if(visited[neighbor] == 0){
                if(dfs(neighbor,visited,pathVisited,adj)) return true;
            }else if(pathVisited[neighbor] == 1) return true;
        }
        pathVisited[node] = 0;
        return false;
    }
}