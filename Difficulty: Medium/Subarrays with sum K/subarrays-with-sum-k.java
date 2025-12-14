class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        int n = arr.length;
        int sum = 0;
        int count = 0;
        int left = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < n; i++){
            sum += arr[i];
            int remove = sum-k;
            count += map.getOrDefault(remove, 0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}