// User function Template for Java

class Solution {
    public static ArrayList<Integer> factorial(int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        
        for(int i = 2; i <= n; i++){
            multiply(result,i);
        }
        return result;
    }
    
    public static void multiply(ArrayList<Integer> result, int num){
        int carry = 0;
        
        for(int i = result.size()-1; i >= 0; i--){
            int product = result.get(i)*num + carry;
            result.set(i,product%10);
            carry = product/10;
        }
        
        while(carry > 0){
            result.add(0,carry%10);
            carry /= 10;
        }
    }
}