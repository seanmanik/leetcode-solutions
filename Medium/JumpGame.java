class JumpGame {

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 1;
        nums[3] = 0;
        nums[4] = 4;
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int curr = 0;
        int left = nums[0];
        while (curr != nums.length - 1) {
            if (curr + left >= nums.length - 1) {
                return true;
            }
            if (left == 0) {
                return false;
            }
            for (int i = 1; i <= left; i++) {
                if (curr + i + nums[curr + i] >= curr + left) {
                    curr = curr + i;
                    left = nums[curr];
                    break;
                } else {
                    if (i == left) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}