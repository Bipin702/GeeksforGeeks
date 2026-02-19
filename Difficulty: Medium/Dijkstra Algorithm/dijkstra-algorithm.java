class Solution {
    class Pair{
        int vertex;
        int distance;
        
        Pair(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }
    }
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.distance-b.distance);
        pq.add(new Pair(src,0));
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.vertex;
            int length = p.distance;
            if(length > dist[node]) continue;
            for(Pair neighbor : adj.get(node)){
                if(dist[node] + neighbor.distance < dist[neighbor.vertex]){
                    dist[neighbor.vertex] = dist[node] + neighbor.distance;
                    pq.add(new Pair(neighbor.vertex,dist[neighbor.vertex]));
                }
            }
        }
        for(int i = 0; i < V; i++){
            if(dist[i] == (int)1e9) dist[i] = -1;
        }
        
        return dist;
    }
}