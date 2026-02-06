class Solution {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        Boolean[][] dp = new Boolean[N][K+1];
        
        return solve(0, arr, K,dp);
    }

    public static boolean solve(int index, int[] arr, int totalSum,Boolean[][] dp) {
        if (totalSum == 0) return true;

        if (index == arr.length || totalSum < 0) return false;
        
        if(dp[index][totalSum] != null) return dp[index][totalSum];

        boolean take = solve(index + 1, arr, totalSum - arr[index],dp);
        boolean notTake = solve(index + 1, arr, totalSum,dp);


         dp[index][totalSum] = take || notTake;
         return dp[index][totalSum];
    }
}
