class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return helper(0, 0, m, n);
    }

    public int helper(int r, int c, int maxR, int maxC) {
        if (r == maxR - 1 && c == maxC - 1) {
            return 1;
        }
        if (r >= maxR || c >= maxC) {
            return 0;
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        int down = helper(r + 1, c, maxR, maxC);
        int right = helper(r, c + 1, maxR, maxC);
        int ans = down + right;
        dp[r][c] = ans;
        return ans;
    }
}