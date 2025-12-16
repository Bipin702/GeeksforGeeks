// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] visited = new int[n][m];
        
        for(int j = 0; j < m; j++){
            // check 1 in first row
            if(visited[0][j] == 0 && grid[0][j] == 1){
                dfs(0,j,visited,grid);
            }
            
            // last row
            if(visited[n-1][j] == 0 && grid[n-1][j] == 1){
                dfs(n-1,j,visited,grid);
            }
        }
        
        for(int i = 0; i < n; i++){
            // first col
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
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int row, int col, int[][] visited, int[][] board){
        visited[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && board[nRow][nCol] == 1){
                dfs(nRow,nCol,visited,board);
            }
        }
    }
}