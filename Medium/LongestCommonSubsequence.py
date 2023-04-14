class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if len(text1) == 0:
            return 0
        elif len(text2) == 0:
            return 0
        size1 = len(text1)
        size2 = len(text2)
        # size1 x size2
        dp = [[-1 for i in range(size2 + 1)] for j in range(size1 + 1)]
        for i in range(size1 + 1):
            dp[i][0] = 0
        for i in range(size2 + 1):
            dp[0][i] = 0
        for i in range(1, size1 + 1):
            for j in range(1, size2 + 1):
                if text1[i - 1] == text2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    first = dp[i - 1][j]
                    second = dp[i][j - 1]
                    dp[i][j] = max(first, second)
        return dp[size1][size2]
