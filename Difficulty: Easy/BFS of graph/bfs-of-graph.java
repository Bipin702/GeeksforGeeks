class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = adj.size();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int[] visited = new int[n];
        visited[0] = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);
            
            for(int neighbor : adj.get(node)){
                if(visited[neighbor] == 0){
                    q.add(neighbor);
                    visited[neighbor] = 1;
                }
            }
        }
        return result;
    }   
}