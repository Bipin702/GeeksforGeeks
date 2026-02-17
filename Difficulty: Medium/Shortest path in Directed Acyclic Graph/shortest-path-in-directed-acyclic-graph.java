// User function Template for Java
class Solution {
    class Pair{
        int vertex;
        int weight;
        
        Pair(int vertex,int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj.get(u).add(new Pair(v,wt));
        }
        
        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(i,visited,st,adj);
            }
        }
        int[] dist = new int[V];
        for(int i = 0; i < V; i++) dist[i] = (int)1e9;
        dist[0] = 0;
        
        while(!st.isEmpty()){
            int node = st.pop();
            
            for(Pair neighbor : adj.get(node)){
                if(dist[node] + neighbor.weight < dist[neighbor.vertex]){
                    dist[neighbor.vertex] = dist[node] + neighbor.weight;
                }
            }
        }
        for(int i = 0; i < V; i++){
            if(dist[i] == (int)1e9) dist[i] = -1;
        }
        return dist;
    }
    
    public void dfs(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj){
        visited[node] = 1;
        
        for(Pair neighbor : adj.get(node)){
            if(visited[neighbor.vertex] == 0){
                dfs(neighbor.vertex,visited,st,adj);
            }
        }
        st.push(node);
    }
}