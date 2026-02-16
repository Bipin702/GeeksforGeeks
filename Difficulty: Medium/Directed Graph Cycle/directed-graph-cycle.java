class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < V; i++) list.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            list.get(u).add(v);
        }
        
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                if(dfs(i,visited,pathVisited,list)) return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(int node , int[] visited, int[] pathVisited, ArrayList<ArrayList<Integer>> list){
        visited[node] = 1;
        pathVisited[node] = 1;
        
        for(int neighbor : list.get(node)){
            if(visited[neighbor] == 0){
                if(dfs(neighbor,visited,pathVisited,list)) return true;
            }else if(pathVisited[neighbor] == 1) return true;
        }
        pathVisited[node] = 0;
        return false;
    }
}