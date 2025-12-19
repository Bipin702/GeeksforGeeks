class Solution {
    public int numberOfPaths(int m, int n) {
        // Code Here
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(m-1,n-1,dp);
    }
    
    public int solve(int row, int col,int[][] dp){
        if(row < 0 || col < 0) return 0;
        if(row == 0 || col == 0) return 1;
        if(dp[row][col] != -1) return dp[row][col];
        int ways = solve(row-1,col,dp) + solve(row,col-1,dp);
        return dp[row][col] = ways;
    }
}