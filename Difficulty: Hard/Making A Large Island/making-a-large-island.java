class Disjoint{
    List<Integer> parent;
    List<Integer> size;

    Disjoint(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for(int i = 0; i <= n; i++){
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

        if(size.get(ulpU) > size.get(ulpV)){
            parent.set(ulpV,ulpU);
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
        }else{
            parent.set(ulpU,ulpV);
            size.set(ulpV, size.get(ulpU) + size.get(ulpV));
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        Disjoint ds = new Disjoint(n*n);

        for(int row = 0; row < n;  row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0) continue;

                int[] delRow = {-1,0,1,0};
                int[] delCol = {0,1,0,-1};

                for(int i = 0; i < 4; i++){
                    int nRow = row + delRow[i];
                    int nCol = col + delCol[i];

                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1){
                        int nodeNo = row*n + col;
                        int adjNo = nRow*n + nCol;

                        ds.UnionBySize(nodeNo,adjNo);
                    }
                }
            }
        }

        int max = 0;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1) continue;

                int[] delRow = {-1,0,1,0};
                int[] delCol = {0,1,0,-1};

                HashSet<Integer> set = new HashSet<>();

                for(int i = 0; i < 4; i++){
                    int nRow = row +  delRow[i];
                    int nCol = col + delCol[i];

                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1){
                        set.add(ds.findParent(nRow*n + nCol));
                    }
                }
                int total = 1;
                for(Integer parents : set){
                    total += ds.size.get(parents);
                }
                max = Math.max(max, total);
            }
        }
        for(int i = 0; i < n*n; i++){
            max = Math.max(max,ds.size.get(ds.findParent(i)));
        }
        return max;
    }
}