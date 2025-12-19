// User function Template for Java

class Solution {
    int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = arr[0];
        int neg = 0;
        
        for(int i = 1; i < n; i++){
            int take = arr[i];
            if(i > 1) take += dp[i-2];
            int notTake = dp[i-1];
            
            dp[i] = Math.max(take,notTake);
        }
        return dp[n-1];
        // Arrays.fill(dp,-1);
        // return solve(n-1,arr,dp);
    }
    
    public int solve(int index, int[] arr,int[] dp){
        if(index == 0) return arr[0];
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];
        int pick = arr[index] + solve(index-2,arr,dp);
        int notPick = solve(index-1,arr,dp);
        
        return dp[index] = Math.max(pick,notPick);
    }
}