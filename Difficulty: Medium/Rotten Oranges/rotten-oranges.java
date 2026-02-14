class Solution {
    class Pair{
        int row;
        int col;
        int time;
        
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRot(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int countFresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] ==  2){
                    q.offer(new Pair(i,j,0));
                    visited[i][j] = 2;
                }else{
                    visited[i][j] = 0;
                }
                
                if(mat[i][j] ==  1) countFresh++;
            }
        }
        int count = 0;
        int tm = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int rows = p.row;
            int cols = p.col;
            int t = p.time;
            tm = Math.max(tm,t);
            
            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,1,0,-1};
            
            for(int i = 0; i < 4; i++){
                int nRow = rows + delRow[i];
                int nCol = cols + delCol[i];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && 
                visited[nRow][nCol] == 0 && mat[nRow][nCol] == 1){
                    visited[nRow][nCol] = 2;
                    q.offer(new Pair(nRow,nCol,t+1));
                    count++;
                }
            }
        }
        
        if(count != countFresh) return -1;
        return tm;
    }
}