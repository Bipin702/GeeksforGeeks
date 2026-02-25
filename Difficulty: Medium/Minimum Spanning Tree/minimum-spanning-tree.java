class Solution {
    class Pair{
        int vertex;
        int dist;
        
        Pair(int vertex, int dist){
            this.vertex = vertex;
            this.dist = dist;
        }
    }
    
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
            
        }
        
        int[] visited = new int[V];
        int sum = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.vertex;
            int weight = p.dist;
            
            if(visited[node] == 1)  continue;
            
            visited[node] = 1;
            sum += weight;
            
            for(Pair neighbor : adj.get(node)){
                if(visited[neighbor.vertex] == 0){
                    pq.add(new Pair(neighbor.vertex,neighbor.dist));
                }
            }
        }
        return sum;
    }
}
