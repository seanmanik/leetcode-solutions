class Solution {
    int[][][] dp;
    public int rob(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        dp = new int[nums.length + 2][total + 1][2];
        for (int i = 0; i < nums.length + 2; i++) {
            for (int j = 0; j < total; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        helper(nums, 0, 0, false);
        return dp[0][0][0] > dp[0][0][1] ? dp[0][0][0] : dp[0][0][1];
    }

    public int helper(int[] nums, int id, int curr, boolean firstTaken) {
        int first = 0;
        if (firstTaken) {
            first = 1;
        }
        if (dp[id][curr][first] != -1) {
            return dp[id][curr][first];
        }
        if (id >= nums.length) {
            dp[id][curr][first] = curr;
            return curr;
        }
        if (id == nums.length - 1) {
            if (firstTaken) {
                dp[id][curr][1] = curr;
                return curr;
            } else {
                dp[id][curr][0] = curr + nums[id];
                return dp[id][curr][0];
            }
        }
        if (id == 0) {
            int takeFirst = helper(nums, id + 2, nums[0], true);
            int dontTakeFirst = helper(nums, id + 1, 0, false);
            dp[0][0][1] = takeFirst;
            dp[0][0][0] = dontTakeFirst;
            return 0;
        }
        int take = helper(nums, id + 2, curr + nums[id], firstTaken);
        int dontTake = helper(nums, id + 1, curr, firstTaken);
        if (take > dontTake) {
            dp[id][curr][first] = take;
            return take;
        }
        dp[id][curr][first] = dontTake;
        return dontTake;
    }
}