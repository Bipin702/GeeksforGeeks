class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        // code here
        int n = txt.length();
        int m = pat.length();
        
        int[] LPS = new int[m];
        LPS[0] = 0;
        int i = 1;
        int length = 0;
        while(i < m){
            if(pat.charAt(i) == pat.charAt(length)){
                length++;
                LPS[i] = length;
                i++;
            }else{
                if(length != 0){
                    length = LPS[length-1];
                }else{
                    LPS[i] = 0;
                    i++;
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int j = 0;
        int k = 0;
        
        while(j < n){
            if(txt.charAt(j) == pat.charAt(k)){
                j++;
                k++;
            }
            
             if (k == m) {
                result.add(j - k);  // match found
                k = LPS[k - 1];
            } else if (j < n && txt.charAt(j) != pat.charAt(k)) {
                if (k != 0) {
                    k = LPS[k - 1];
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}