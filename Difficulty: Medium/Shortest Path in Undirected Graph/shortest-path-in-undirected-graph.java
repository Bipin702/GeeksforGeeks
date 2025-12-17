class Solution {
    
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        int[] dist = new int[V];
        
        for(int i = 0; i < V; i++) dist[i] = (int)1e9;
        dist[src] = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int neighbor : adj.get(node)){
                if(dist[node] + 1 < dist[neighbor]){
                    dist[neighbor] = 1 + dist[node];
                    q.offer(neighbor);
                }
            }
        }
        
        for(int i = 0; i < V; i++){
            if(dist[i] == (int)1e9) dist[i] = -1;
        }
        return dist;
    }
}
