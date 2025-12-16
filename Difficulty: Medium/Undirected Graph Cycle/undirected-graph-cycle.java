class Solution {
    class Pair{
        int src;
        int dest;
        
        Pair(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] row : edges){
            int u = row[0];
            int v = row[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] visited = new int[V];
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                if(CheckCycle(i,visited,adj)) return true;
            }
        }
        return false;
    }
    
    public boolean CheckCycle(int node, int[] visited, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new LinkedList<>();
        visited[node] = 1;
        q.add(new Pair(node,-1));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int nodes = p.src;
            int parent = p.dest;
            
            for(int neighbor : adj.get(nodes)){
                if(visited[neighbor] == 0){
                    visited[neighbor] = 1;
                    q.offer(new Pair(neighbor,nodes));
                }else if(neighbor != parent){
                    return true;
                }
            }
        }
        return false;
    }
}