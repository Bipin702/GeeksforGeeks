class Solution {
    class Pair{
        int nodes;
        int distance;
        
        Pair(int nodes, int distance){
            this.nodes = nodes;
            this.distance = distance;
        }
    }
    public int spanningTree(int V, int[][] edges) {
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
        
        int[] visited = new int[V];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        
        pq.add(new Pair(0,0));
        int sum = 0;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.nodes;
            int weight = p.distance;
            
            if(visited[node] == 1) continue;
            
            visited[node] = 1;
            sum += weight;
            
            for(Pair neighbor : adj.get(node)){
                if(visited[neighbor.nodes] == 0){
                    pq.add(new Pair(neighbor.nodes, neighbor.distance));
                }
            }
        }
        return sum;
    }
}
