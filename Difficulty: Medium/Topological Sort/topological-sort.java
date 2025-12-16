class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] row : edges){
            int u = row[0];
            int v = row[1];
            
            adj.get(u).add(v);
        }
        
        Stack<Integer> st = new Stack<>();
        
        int[] visited = new int[V];
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(i,visited,adj,st);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!st.isEmpty()){
            result.add(st.pop());
        }
        return result;
    }
    
    public void dfs(int node, int[] visited,ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        visited[node] = 1;
        
        for(int neighbor : adj.get(node)){
            if(visited[neighbor] == 0){
                dfs(neighbor,visited,adj,st);
            }
        }
        st.push(node);
    }
}