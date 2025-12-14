class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            if(map.size() > k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            
            maxLen = Math.max(maxLen,i-left+1);
        }
        if(map.size() < k) return -1;
        return maxLen;
    }
}