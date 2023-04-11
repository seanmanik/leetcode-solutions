class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }       
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hs.contains(nums[i] - 1)) {
                continue;
            } else {
                int counter = 0;
                int curr = nums[i];
                while (hs.contains(curr)) {
                    counter++;
                    curr++;
                }
                if (counter > high) {
                    high = counter;
                }
            }
        }
        return high;
    }
}