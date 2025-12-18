class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            int left = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) right = dp[i-2] + Math.abs(height[i] - height[i-2]);
            
            dp[i] = Math.min(left,right);
        }
        return dp[n-1];
        // Arrays.fill(dp,-1);
        // return solve(n-1,height,dp);
    }
    
    public int solve(int index, int[] height,int[] dp){
        if(index == 0) return 0;
        if(dp[index] != -1) return dp[index];
        int right = Integer.MAX_VALUE;
        int left = solve(index-1,height,dp) + Math.abs(height[index] - height[index-1]) ;
        if(index > 1) right = solve(index-2, height,dp) + Math.abs(height[index] - height[index-2]);
        
        return dp[index] = Math.min(left,right);
    }
}