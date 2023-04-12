class Solution {

    int dp[][];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        dp = new int[row][col];
        return helper(obstacleGrid, 0, 0, row, col);
    }

    public int helper(int[][] obstacleGrid, int row, int col, int maxRow, int maxCol) {
        if (row == maxRow) {
            return 0;
        }
        if (col == maxCol) {
            return 0;
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        if (obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (row == maxRow - 1 && col == maxCol - 1) {
            return 1;
        }
        int right = helper(obstacleGrid, row, col + 1, maxRow, maxCol);
        int down = helper(obstacleGrid, row + 1, col, maxRow, maxCol);
        int ans = right + down;
        dp[row][col] = ans;
        return ans;
    }
}