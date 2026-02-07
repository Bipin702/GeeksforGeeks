class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        ArrayList<String> ans = new ArrayList<>();
        
        if(maze[0][0] == 0 || maze[n-1][n-1] == 0) return ans;
        
        int[][] visited = new int[n][n];
        StringBuilder path = new StringBuilder();
        visited[0][0] = 1;
        dfs(0,0,maze,ans,path,visited,n);
        Collections.sort(ans);
        return ans;
    }
    
    public void dfs(int row, int col, int[][] maze,ArrayList<String> ans,
    StringBuilder path,int[][] visited,int n){
        if(row == n-1 && col == n-1){
            ans.add(path.toString());
        }
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        char[] moves = {'U','R','D','L'};
        
        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && maze[nRow][nCol]==1
            && visited[nRow][nCol] == 0){
                visited[nRow][nCol] = 1;
                path.append(moves[i]);
                dfs(nRow,nCol,maze,ans,path,visited,n);
                
                path.deleteCharAt(path.length() - 1);
                visited[nRow][nCol] = 0;
            }
        }
    }
}