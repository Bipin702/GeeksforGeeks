// User function Template for Java

class Solution {
    class Pair{
        int node;
        int step;
        
        Pair(int node, int step){
            this.node = node;
            this.step = step;
        }
    }
    final int mod = 100000;
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int n = arr.length;
        if (start == end) return 0;
        if (arr == null || n == 0) return -1;
        
        int[] dist = new int[mod];
        
        Arrays.fill(dist,(int)1e9);
        
        dist[start] = 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start,0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int nodes = p.node;
            int steps = p.step;
            
            for(int num : arr){
                int next = (num*nodes)%mod;
                
                if(next == end) return steps+1;
                if(steps+1 < dist[next]){
                    dist[next] = steps+1;
                    q.offer(new Pair(next,steps+1));
                }
            }
        }
        return -1;
    }
}
