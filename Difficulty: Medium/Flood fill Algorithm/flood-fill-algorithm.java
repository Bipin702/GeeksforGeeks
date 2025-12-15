class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int currColor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        int[][] result = image;

        dfs(sr,sc,image,currColor,newColor,result);
        return result;
    }

    public void dfs(int row, int col, int[][] image, int currColor, int newColor, int[][] result){
        result[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int d = 0; d < 4; d++){
            int nRow = row + delRow[d];
            int nCol = col + delCol[d];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && image[nRow][nCol] == currColor && result[nRow][nCol] != newColor){
                dfs(nRow,nCol,image,currColor,newColor,result);
            }
        }
    }
}