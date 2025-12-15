class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = adj.size();
        int[] visited = new int[n];
        
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(i,adj,result,visited);
            }
        }
        return result;
    }
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result,int[] visited){
        visited[node] = 1;
        result.add(node);
        
        for(int neighbor : adj.get(node)){
            if(visited[neighbor] == 0){
                dfs(neighbor,adj,result,visited);
            }
        }
    }
}