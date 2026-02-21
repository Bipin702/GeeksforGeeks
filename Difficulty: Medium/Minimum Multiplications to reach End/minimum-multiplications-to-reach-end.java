// User function Template for Java

class Solution {
    class Pair{
        int node;
        int count;
        
        Pair(int node, int count){
            this.node = node;
            this.count = count;
        }
    }
    
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if(start == end) return 0;
        int n = arr.length;
        int mod = 100000;
        boolean[] visited = new boolean[mod];
        visited[start] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int result = p.node;
            int times = p.count;
            
            
            for(int i = 0; i < n; i++){
                int mul = (result * arr[i])%mod;
                if(!visited[mul]){
                    if(mul == end) return times+1;
                    visited[mul] = true;
                    q.add(new Pair(mul,times+1));
                }
            }
        }
        return -1;
    }
}
