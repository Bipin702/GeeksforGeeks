class Solution {
    class Pair{
        int dest;
        int weight;
        
        Pair(int dest, int weight){
            this.dest = dest;
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
        
        for(int i = 0; i <= n; i++) dist[i] = (int) 1e9;
        int[] parent = new int[n+1];
        
        for(int i = 0; i <= n; i++) parent[i] = i;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        dist[1] = 0;
        
        pq.offer(new Pair(1,0));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.dest;
            int length = p.weight;
            
            if(length > dist[node]) continue;
            
            for(Pair neighbor : adj.get(node)){
                if(dist[node] + neighbor.weight < dist[neighbor.dest]){
                    dist[neighbor.dest] = dist[node] + neighbor.weight;
                    parent[neighbor.dest] = node;
                    pq.offer(new Pair(neighbor.dest,dist[neighbor.dest]));
                }
            }
        }
        if (dist[n] == (int) 1e9) {
            return Arrays.asList(-1);
        }
        ArrayList<Integer> path = new ArrayList<>();
        int index = n;
        while(parent[index] != index){
            path.add(index);
            index = parent[index];
        }
        path.add(1);
        Collections.reverse(path);
        List<Integer> result = new ArrayList<>();
        result.add(dist[n]);
        result.addAll(path);
        return result;
    }
}