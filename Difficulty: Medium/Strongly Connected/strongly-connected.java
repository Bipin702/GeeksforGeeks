class Solution {
    // Function to find number of strongly connected components in the graph
    public int kosaraju(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] row : edges){
            int u = row[0];
            int v = row[1];
            
            adj.get(u).add(v);
        }
        
        int[] visited = new int[V];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0)
            dfs(i,visited,adj,st);
        }
        
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for(int i = 0; i < V; i++) rev.add(new ArrayList<>());
        
        for(int i = 0; i < V; i++){
            visited[i] = 0;
            for(int neighbor : adj.get(i))
            rev.get(neighbor).add(i);
        }
        
        int scc = 0;
        
        while(!st.isEmpty()){
            int node = st.pop();
        
            if(visited[node] == 0){
                scc++;
                dfs2(visited,node,rev);
            }
        }
        return scc;
    }
    
    public void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        visited[node] = 1;
        
        for(int neighbor : adj.get(node)){
            if(visited[neighbor] == 0)
            dfs(neighbor,visited,adj,st);
        }
        st.push(node);
    }
    
    public void dfs2(int[] visited, int node, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        
        for(int neighbor : adj.get(node)){
            if(visited[neighbor] == 0){
                dfs2(visited,neighbor,adj);
            }
        }
    }
}