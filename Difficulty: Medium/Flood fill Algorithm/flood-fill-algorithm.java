class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int  n = image.length;
        int m = image[0].length;
        int color = image[sr][sc];
        
        int[][] visited = new int[n][m];
        
        dfs(sr,sc,visited,image,color,newColor);
        
        return image;
    }
    
    public void dfs(int sr, int sc, int[][] visited, int[][] image,int color, int newColor){
        image[sr][sc] = newColor;
        visited[sr][sc] = 1;
        
        int n = image.length;
        int m = image[0].length;
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        for(int i = 0; i < 4; i++){
            int nRow = sr + delRow[i];
            int nCol = sc + delCol[i];
            
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && image[nRow][nCol] == color){
                image[nRow][nCol] = newColor;
                dfs(nRow,nCol,visited,image,color,newColor);
            }
        }
    }
}