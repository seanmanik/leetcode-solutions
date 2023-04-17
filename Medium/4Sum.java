class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hs = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int begin = j + 1;
                int end = nums.length - 1;
                long curr = (long) nums[i] + (long) nums[j] + (long) nums[begin] + (long) nums[end];
                while (begin < end) {
                    if (curr == target) {
                        List<Integer> toAdd = Arrays.asList(nums[i], nums[j], nums[begin], nums[end]);
                        hs.add(toAdd);
                        begin++;
                        end--;
                        curr = nums[i] + nums[j] + nums[begin] + nums[end];
                    } else if (curr < target) {
                        begin++;
                        curr = nums[i] + nums[j] + nums[begin] + nums[end];
                    } else {
                        end--;
                        curr = nums[i] + nums[j] + nums[begin] + nums[end];
                    }
                }
            }
        }
        List<List<Integer>> toReturn = new ArrayList<>();
        for (List<Integer> l : hs) {
            toReturn.add(l);
        }
        return toReturn;
    }
}