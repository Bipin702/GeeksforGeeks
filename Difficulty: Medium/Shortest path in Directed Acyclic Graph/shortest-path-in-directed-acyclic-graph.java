// User function Template for Java
class Solution {
    class Pair{
        int dest;
        int weight;
        
        Pair(int dest, int weight){
            this.dest = dest;
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
            if(visited[i] == 0)
            dfs(i,visited,st,adj);
        }
        
        int[] distance = new int[V];
        
        for(int i = 0; i < V; i++) distance[i] = (int)1e9;
        distance[0] = 0;
        
        while(!st.isEmpty()){
            int node = st.pop();
            
            if(distance[node] != (int)1e9){
                for(Pair neighbor : adj.get(node)){
                    if(distance[node] + neighbor.weight < distance[neighbor.dest]){
                        distance[neighbor.dest] = distance[node] + neighbor.weight;
                    }
                }
            }
        }
        for(int i = 0; i < V; i++){
            if(distance[i] == (int)1e9) distance[i] = -1;
        }
        return distance;
    }
    
    public void dfs(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj){
        visited[node] = 1;
        
        for(Pair neighbor : adj.get(node)){
            if(visited[neighbor.dest] == 0)
            dfs(neighbor.dest,visited,st,adj);
        }
        st.push(node);
    }
}