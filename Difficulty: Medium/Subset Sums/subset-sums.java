// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        int n = arr.length;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = solve(arr);
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(ArrayList<Integer> list : ans){
            int sum = 0;
            for(int num : list){
                sum += num;
            }
            res.add(sum);
        }
        
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> solve(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for(int num : nums){
            int n = ans.size();
            for(int i = 0; i < n; i++){
                ArrayList<Integer> inner = new ArrayList<>(ans.get(i));
                inner.add(num);
                ans.add(inner);
            }
        }
        return ans;
    }
}