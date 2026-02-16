class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        int[] indegree = new int[V];
        
        for(int i = 0; i < V; i++){
            for(int node : adj.get(i)) indegree[node]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            
            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        return ans;
    }
    
    public void dfs(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        
        for(int neighbor : adj.get(node)){
            if(visited[neighbor] == 0)
            dfs(neighbor,visited,st,adj);
        }
        
        st.push(node);
    }
}