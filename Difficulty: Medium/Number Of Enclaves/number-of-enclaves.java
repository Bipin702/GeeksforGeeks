// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        
        int[][] visited = new int[n][m];
        
        for(int i = 0; i < m; i++){
            if(visited[0][i] == 0 && grid[0][i] == 1){
                dfs(0,i,visited,grid);
            }
            
            if(visited[n-1][i] == 0 && grid[n-1][i] == 1){
                dfs(n-1,i,visited,grid);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(visited[i][0] == 0 && grid[i][0] == 1){
                dfs(i,0,visited,grid);
            }
            
            if(visited[i][m-1] == 0 && grid[i][m-1] == 1){
                dfs(i,m-1,visited,grid);
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1)
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int row, int col, int[][] visited, int[][] grid){
        visited[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                dfs(nRow,nCol,visited,grid);
            }
        }
    }
}