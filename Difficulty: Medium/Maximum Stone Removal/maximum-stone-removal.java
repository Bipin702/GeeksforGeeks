class Solution {
    int maxRemove(int[][] stones) {
        // Code here
        int n = stones.length;
        int[] visited = new int[n];
        int components = 0;
        
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(i,visited,stones);
                components++;
            }
        }
        
        return n - components;
    }
    
    public void dfs(int node, int[] visited, int[][] stones){
        visited[node] = 1;
        int n = stones.length;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0 && (stones[node][0] == stones[i][0] || stones[node][1] == stones[i][1])){
                dfs(i,visited,stones);
            }
        }
    }
}
