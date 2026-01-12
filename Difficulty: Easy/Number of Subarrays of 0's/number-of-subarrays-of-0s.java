// User function Template for Java

class Solution {
    long no_of_subarrays(int N, int[] arr) {
        // Write your code here
        long total = 0;
        long count = 0;
        for(int i = 0; i < N; i++){

            if(arr[i] == 0){
                count++;
            }else{
                count = 0;
            }
            
            total += count;
        }
        return total;
    }
}