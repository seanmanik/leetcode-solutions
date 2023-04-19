class Solution
{
public:
    int minSubArrayLen(int target, vector<int> &nums)
    {
        if (nums.size() == 1)
        {
            if (target == nums[0])
            {
                return 1;
            }
            return 0;
        }
        int left = 0;
        int right = 1;
        if (nums[0] > target || nums[1] > target)
        {
            return 1;
        }
        int curr = nums[0] + nums[1];
        int size = nums.size();
        int min = 1000000;
        while (right < size)
        {
            if (curr >= target)
            {
                int diff = right - left + 1;
                if (diff < min)
                {
                    min = diff;
                }
                curr -= nums[left];
                left++;
            }
            else if (curr > target)
            {
                if (left == right)
                {
                    left++;
                    right++;
                    if (right == size)
                    {
                        break;
                    }
                    curr = nums[left];
                }
                else
                {
                    curr -= nums[left];
                    left++;
                }
            }
            else if (curr < target)
            {
                right++;
                if (right == size)
                {
                    break;
                }
                curr += nums[right];
            }
        }
        return min == 1000000 ? 0 : min;
    }
};