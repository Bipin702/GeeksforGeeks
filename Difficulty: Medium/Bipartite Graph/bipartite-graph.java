class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] row : edges){
            int u = row[0];
            int v = row[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[V];
        
        for(int i = 0; i < V; i++) color[i] = -1;
        
        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(Check(i,color,adj)== false) return false;
            }
        }
        return true;
    }
    
    public boolean Check(int start, int[] color, ArrayList<ArrayList<Integer>> adj){
        color[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int neighbor : adj.get(node)){
                if(color[neighbor] == -1){
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                }else if(color[neighbor] == color[node]) return false;
            }
        }
        return true;
    }
}