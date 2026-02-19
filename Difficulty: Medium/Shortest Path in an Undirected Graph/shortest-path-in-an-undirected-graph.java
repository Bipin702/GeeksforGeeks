class Solution {
    class Pair{
        int vertex;
        int weight;
        
        Pair(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(dist,(int)1e9);
        for(int i = 1; i <= n; i++) parent[i] = i;
        dist[1] = 0;
    
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight-b.weight);
        
        pq.add(new Pair(1,0));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.vertex;
            int distance = p.weight;
            
            if(distance > dist[node]) continue;
            
            for(Pair neighbor : adj.get(node)){
                if(dist[node] + neighbor.weight < dist[neighbor.vertex]){
                    dist[neighbor.vertex] = dist[node] + neighbor.weight;
                    parent[neighbor.vertex] = node;
                    pq.add(new Pair(neighbor.vertex,dist[neighbor.vertex]));
                }
            }
        }
        if(dist[n] == (int)1e9){
            return Arrays.asList(-1);
        }
        List<Integer> path = new ArrayList<>();
        int node =  n;
        
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        
        path.add(1);
        Collections.reverse(path);
        
        List<Integer> result = new ArrayList<>();
        result.add(dist[n]);
        result.addAll(path);
        return result;
    }
}