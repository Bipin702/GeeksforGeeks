class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        
        // sort according to finish time
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs1(i,vis,st,adj);
            }
        }
        
        //Reverse the graph
        ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();
        
        for(int i = 0; i < n; i++) reverse.add(new ArrayList<>());
        
        for(int i = 0; i < n; i++){
            vis[i] = 0;
            
            for(int neighbor : adj.get(i)){
                reverse.get(neighbor).add(i);
            }
        }
        
        //Do dfs in the graph
        int scc = 0;
        
        while(!st.isEmpty()){
            int node = st.pop();
            
            if(vis[node] == 0){
                dfs(node,vis,reverse);
                scc++;
            }
        }
        return scc;
    }
    
    public void dfs1(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        
        for(Integer neighbor : adj.get(node)){
            if(visited[neighbor] == 0){
                dfs1(neighbor,visited,st,adj);
            }
        }
        st.push(node);
    }
    
    public void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> reverse){
        visited[node] = 1;
        
        for(Integer neighbor : reverse.get(node)){
            if(visited[neighbor] == 0){
                dfs(neighbor, visited, reverse);
            }
        }
    }
}