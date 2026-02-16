class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        int n = edges.length;
        int m = edges[0].length;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < V; i++) list.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int i = edge[0];
            int j = edge[1];
            
            list.get(i).add(j);
            list.get(j).add(i);
        }
        
        int[] color = new int[V];
        
        for(int i = 0; i < V; i++) color[i] = -1;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(color[i] == -1){
            if(bfs(i,q,list,color) == false) return false;
            }
        }
        
        return true;
    }
    
    public boolean bfs(int row, Queue<Integer> q, ArrayList<ArrayList<Integer>> list,int[] color){
        color[row] = 0;
        q.add(row);
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int neighbor : list.get(node)){
                if(color[neighbor] == -1){
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                }else if(color[neighbor] == color[node]) return false;
            }
        }
        return true;
    }
}