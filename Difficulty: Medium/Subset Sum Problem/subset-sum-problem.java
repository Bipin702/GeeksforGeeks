class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        return solve(0,arr,sum,dp);
    }
    
    public static Boolean solve(int index, int[] arr, int sum,Boolean[][]dp){
        if(sum == 0) return true;
        
        if(index == arr.length) return false;
        
        if(dp[index][sum] != null) return dp[index][sum];
        
        boolean notTake = solve(index+1, arr,sum,dp);
        
        boolean take = false;
        
        if(sum >= arr[index])
        take = solve(index+1,arr,sum-arr[index],dp);
        
        return dp[index][sum] = take || notTake;
    }
}