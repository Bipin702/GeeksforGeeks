class Solution {
    int countWays(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,n,dp);
    }
    
    public int solve(int index, int n, int[] dp){
        if(index == n || index == n-1) return 1;
        
        if(dp[index] != -1) return dp[index];
        
        int ways1 = solve(index+1, n, dp);
        int ways2 = solve(index+2, n, dp);
        
        dp[index] = ways1 + ways2;
        return dp[index];
    }
}