class Solution {
    HashSet<Integer> cols;
    HashSet<Integer> diagsUp;
    HashSet<Integer> diagsDown;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        cols = new HashSet<>();
        diagsUp = new HashSet<>();
        diagsDown = new HashSet<>();
        int[][] board = new int[n][];
        for (int i = 0; i < n; i++ ){
            int[] arr = new int[n];
            board[i] = arr;
        }
        backtrack(0, board, n);
        return result;
    }

    public void backtrack(int row, int[][] board, int n) {
        if (row == n) {
            List<String> currBoard = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 0) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                currBoard.add(sb.toString());
            }
            result.add(currBoard);
        }
        for (int i = 0; i < n; i++) {
            //trying all cols;
            if (!cols.contains(i) && !diagsUp.contains(row + i) && !diagsDown.contains(row - i)) {
                board[row][i] = 1;
                cols.add(i);
                diagsUp.add(row + i);
                diagsDown.add(row - i);
                backtrack(row + 1, board, n);
                cols.remove(i);
                diagsUp.remove(row + i);
                diagsDown.remove(row - i);
                board[row][i] = 0;
            } else {
                continue;
            } 
        }
    }

}