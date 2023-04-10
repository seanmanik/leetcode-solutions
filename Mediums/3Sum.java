class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hs = new HashSet<>();
        List<List<Integer>> toReturn = new Arraylist<ArrayList<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int curr = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (curr + nums[start] + nums[end] == 0) {
                    List<Integer> toAdd = new ArrayList<>();
                    toAdd.add(curr);
                    toAdd.add(nums[start]);
                    toAdd.add(nums[end]);
                    hs.add(toAdd);
                    end--;
                } else if (curr + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        for (List<Integer> ls : hs) {
            toReturn.add(ls);
        }
        return toReturn;
    }
}