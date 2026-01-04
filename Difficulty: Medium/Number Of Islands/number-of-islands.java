// User function Template for Java
class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    DisjointSet(int n){
        for(int i = 0; i <= n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)) return node;

        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);

        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v, size.get(ulp_u)+ size.get(ulp_v));
        } else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u, size.get(ulp_u)+ size.get(ulp_v));
        }
    }
}

class Solution {

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        DisjointSet ds = new DisjointSet(rows*cols);
        
        List<Integer> ans = new ArrayList<>();
        
        int[][] vis = new int[rows][cols];
        
        int n = operators.length;
        
        int count = 0;
        
        for(int i = 0; i < n ; i++){
            int row  = operators[i][0];
            int col = operators[i][1];
            
            if(vis[row][col] == 1){ 
                ans.add(count);
                continue;
            }
            vis[row][col] = 1;
            count++;
            
            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,1,0,-1};
            
            for(int d = 0; d <4; d++){
                int adjRow = row + delRow[d];
                int adjCol =  col + delCol[d];
                
                if(adjRow < rows && adjRow >= 0 && adjCol < cols && adjCol >= 0){
                    if(vis[adjRow][adjCol] == 1){ 
                        int nodeNo = row * cols + col;
                        int adjNo = adjRow * cols + adjCol;
                        
                        if(ds.findParent(nodeNo) != ds.findParent(adjNo)){
                            count--;
                            ds.unionBySize(nodeNo,adjNo);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}