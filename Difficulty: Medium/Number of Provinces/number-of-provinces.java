// User function Template for Java
class Disjoint{
        List<Integer> parent;
        List<Integer> size;
        
        Disjoint(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>();
            
            for(int i = 0; i < n; i++){
                parent.add(i);
                size.add(1);
            }
        }
        
        public int findParent(int node){
            if(node == parent.get(node)) return node;
            
            int ulp = findParent(parent.get(node));
            parent.set(node,ulp);
            return ulp;
        }
        
        public void UnionBySize(int u, int v){
            int ulpU = findParent(u);
            int ulpV = findParent(v);
            
            if(ulpU == ulpV) return;
            
            if(size.get(ulpU) < size.get(ulpV)){
                parent.set(ulpU,ulpV);
                size.set(ulpV, size.get(ulpU)+size.get(ulpV));
            }else{
                parent.set(ulpV,ulpU);
                size.set(ulpU, size.get(ulpU) + size.get(ulpV));
            }
        }
    }
    
class Solution {
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        Disjoint dsu = new Disjoint(V);
        
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(adj.get(i).get(j) == 1){
                    dsu.UnionBySize(i,j);
                }
            }
        }
        
        int count = 0;
        
        for (int i = 0; i < V; i++) {
            if (dsu.findParent(i) == i) {
                count++;
            }
        }
        return count;
    }
}