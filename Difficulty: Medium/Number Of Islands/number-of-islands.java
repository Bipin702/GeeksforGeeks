// User function Template for Java
 
class Solution {

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        List<Integer> ans = new ArrayList<>();
        
        int[][] grid = new int[rows][cols];
        
        for(int[] op : operators){
            int r = op[0];
            int c = op[1];
            
            grid[r][c] = 1;
            
            ans.add(countIslands(grid,rows,cols));
        }
        return ans;
    }
    
    public int countIslands(int[][] grid, int rows, int cols){
        int[][] visited = new int[rows][cols];
        
        int count = 0;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    dfs(grid,i,j,visited); 
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int[][] grid, int row, int col, int[][] visited){
        visited[row][col] = 1;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if(nRow >= 0 && nRow < rows && nCol >= 0 && 
            nCol < cols && grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0){
                dfs(grid, nRow, nCol, visited);
            } 
        }
    }
}