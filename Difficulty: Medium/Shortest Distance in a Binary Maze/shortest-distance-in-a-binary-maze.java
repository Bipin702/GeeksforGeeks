// User function Template for Java

class Solution {
    class Pair{
        int row;
        int col;
        int weight;
        
        Pair(int row, int col,int weight){
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        // Your code here
        if(source[0] == destination[0] && source[1] == destination[1]) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)1e9;
            }
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(source[0],source[1],1));
        dist[source[0]][source[1]] = 0;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int rows = p.row;
            int cols = p.col;
            int length = p.weight;
            
            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,1,0,-1};
            
            for(int i = 0; i < 4; i++){
                int nRow = rows + delRow[i];
                int nCol = cols + delCol[i];
                
                if(nRow < n && nRow >= 0 && nCol < m && nCol >= 0 && grid[nRow][nCol] == 1 && length+1 < dist[nRow][nCol]){
                    dist[nRow][nCol] = length+1;
                    if(nRow == destination[0] && nCol == destination[1]) return length;
                    q.offer(new Pair(nRow,nCol,length+1));
                }
            }
        }
        return -1;
    }
}
