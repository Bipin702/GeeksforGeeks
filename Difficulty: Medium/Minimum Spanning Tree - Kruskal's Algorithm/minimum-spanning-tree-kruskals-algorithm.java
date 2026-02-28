// User function Template for Java
import java.util.*;
class Disjoint{
        ArrayList<Integer> parent;
        ArrayList<Integer> size;
        
        Disjoint(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>();
            
            for(int i = 0; i < n; i++){
                parent.add(i);
                size.add(1);
            }
        }
        
        public int findParent(int node){
            if(node ==  parent.get(node)) return node;
            
            int ulp = findParent(parent.get(node));
            parent.set(node,ulp);
            return ulp;
        }
        
        public void unionBySize(int u, int v){
            int ulpU = findParent(u);
            int ulpV = findParent(v);
            
            if(ulpU == ulpV) return;
            
            if(size.get(ulpU) < size.get(ulpV)){
                parent.set(ulpU, ulpV);
                size.set(ulpV,size.get(ulpU) + size.get(ulpV));
            }else{
                parent.set(ulpV,ulpU);;
                size.set(ulpU,size.get(ulpU) + size.get(ulpV));
            }
        }
    }

class Solution {
    static class Pair{
        int src;
        int dest;
        int weight;
        
        Pair(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        ArrayList<Pair> adj = new ArrayList<>();
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj.add(new Pair(u,v,wt));
        }
        
        Collections.sort(adj, (a,b) -> a.weight - b.weight);
        
        Disjoint dsu = new Disjoint(V);
        int sum = 0;
        
        
        for(Pair edge : adj){
            int u = edge.src;
            int v = edge.dest;
            int wt = edge.weight;
            
            if(dsu.findParent(u) != dsu.findParent(v)){
                sum += wt;
                dsu.unionBySize(u,v);
            }
        }
        return sum;
    }
}
