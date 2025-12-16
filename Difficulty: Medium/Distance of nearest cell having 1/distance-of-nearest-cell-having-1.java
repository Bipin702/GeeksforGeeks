class Solution {
    class Pair {
        int row, col, dist;
        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        // Step 1: Push all 1s into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = 1;
                    q.offer(new Pair(i, j, 0));
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // Step 2: BFS
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int dist = p.dist;

            distance[row][col] = dist;

            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow >= 0 && nRow < n &&
                    nCol >= 0 && nCol < m &&
                    visited[nRow][nCol] == 0) {

                    visited[nRow][nCol] = 1;
                    q.offer(new Pair(nRow, nCol, dist + 1));
                }
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(distance[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }
}
