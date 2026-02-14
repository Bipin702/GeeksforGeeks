class Solution {
    class Pair{
        int node;
        int parent;
        
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int row = edge[0];
            int col = edge[1];
            
            adj.get(row).add(col);
            adj.get(col).add(row);
        }
        
        int[] visited = new int[V];
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0)
            if(bfs(i,visited,adj)) return true;
        }
        return false;
    }
    
    public boolean bfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(node,-1));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int src =  p.node;
            int parents = p.parent;
            
            for(int neighbor : adj.get(src)){
                if(visited[neighbor] == 0){
                    visited[neighbor] = 1;
                    q.offer(new Pair(neighbor,src));
                }else{
                    if(parents != neighbor) return true;
                }
            }
        }
        return false;
    }
}