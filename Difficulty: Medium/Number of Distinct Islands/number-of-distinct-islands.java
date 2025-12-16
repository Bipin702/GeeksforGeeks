// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        
        HashSet<ArrayList<String>> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,grid,visited,i,j,list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    
    public void dfs(int row, int col, int[][] grid, int[][] visited, int row0, int col0, ArrayList<String> list){
        visited[row][col] = 1;
        list.add((row-row0) +" "+ (col-col0));
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                dfs(nRow,nCol,grid,visited,row0,col0,list);
            }
        }
    }
}
