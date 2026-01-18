// User function Template for Java

class Solution {
    public int[] antiDiagonalPattern(int[][] matrix) {
        // Code here
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[] result = new int[n*m];
        int idx = 0;
        for(int i = 0; i < m; i++){
            int row = 0;
            int col = i;
            
            while(col >= 0 && row < n){
                result[idx++] = matrix[row][col];
                row++;
                col--;
            }
        }
        
        for(int i = 1; i < n; i++){
            int row = i;
            int col = n-1;
            
            while(col >= 0 && row < n){
                result[idx++] = matrix[row][col];
                row++;
                col--;
            }
        }
        return result;
    }
}