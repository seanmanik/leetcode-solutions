class Solution {
    HashSet<Integer> cols;
    HashSet<Integer> diagsUp;
    HashSet<Integer> diagsDown;
    List<String> result;

    public int totalNQueens(int n) {
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
        HashSet<String> count = new HashSet<>();
        int res = 0;
        for (String s : result) {
            if (!count.contains(s)) {
                count.add(s);
                res++;
            }
        }
        return res;
    }

    public void backtrack(int row, int[][] board, int n) {
        if (row == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
                }
            }
            result.add(sb.toString());
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