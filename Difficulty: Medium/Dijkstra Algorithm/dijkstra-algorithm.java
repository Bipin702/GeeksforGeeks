class Solution {
    class Pair{
        int node;
        int distance;
        
        Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        
        for(int i = 0; i < V; i++) list.add(new ArrayList<>());;
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            list.get(u).add(new Pair(v,wt));
            list.get(v).add(new Pair(u,wt));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance-y.distance);
        
        int[] dist = new int[V];
        
        for(int i = 0; i < V; i++) dist[i] = (int)1e9;
        dist[src] = 0;
        pq.offer(new Pair(src,0));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int nodes = p.node;
            int length = p.distance;
            if(length > dist[nodes]) continue;
            for(Pair neighbor : list.get(nodes)){
                if(dist[nodes]+neighbor.distance < dist[neighbor.node]){
                    dist[neighbor.node] = dist[nodes] + neighbor.distance;
                    pq.offer(new Pair(neighbor.node, dist[neighbor.node]));
                }
            }
        }
        return dist;
    }
}