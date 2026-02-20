// User function Template for Java

class Solution {
    class Pair{
        int row;
        int col;
        int weight;
        
        Pair(int row, int col, int weight){
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        // Your code here
        if(source[0] == destination[0] && source[1] == destination[1]) return 0;
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        int m = grid[0].length;
        
        int[][] visited = new int[n][m];
        visited[source[0]][source[1]] = 1;
        
        pq.add(new Pair(source[0],source[1],0));
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int startR = p.row;
            int startC = p.col;
            int length = p.weight;
            
            if(startR == destination[0] && startC == destination[1]) return length;
            
            for(int i = 0; i < 4; i++){
                int nRow = startR + delRow[i];
                int nCol = startC + delCol[i];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0){
                    visited[nRow][nCol] = 1;
                    pq.add(new Pair(nRow,nCol,length+1));
                }
            }
        }
        return -1;
    }
}
