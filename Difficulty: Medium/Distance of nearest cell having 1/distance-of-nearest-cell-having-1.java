class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.offer(new Pair(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }
        
        int[] delRow = {-1,0,1,0};
        int[] delCol ={0,1,0,-1};
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int length = p.dist;
            distance[r][c] = length;
            
            for(int i = 0; i < 4; i++){
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0){
                    visited[nRow][nCol] = 1;
                    q.offer(new Pair(nRow,nCol,length+1));
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            ArrayList<Integer> sub = new ArrayList<>();
            for(int j = 0; j < m; j++){
                sub.add(distance[i][j]);
            }
            ans.add(sub);
        }
        
        return ans;
    }
}
