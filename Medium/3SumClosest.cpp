class Solution
{
public:
    int abs(int num)
    {
        if (num < 0)
        {
            return num * -1;
        }
        return num;
    }
    int threeSumClosest(vector<int> &nums, int target)
    {
        int closest = 1000000;
        int curr = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 2; i++)
        {
            curr = 1000000;
            int begin = i + 1;
            int end = nums.size() - 1;
            while (begin < end)
            {
                curr = nums[i] + nums[begin] + nums[end];
                if (abs(curr - target) < abs(closest - target))
                {
                    closest = curr;
                }
                if (curr < target)
                {
                    begin++;
                }
                else
                {
                    end--;
                }
            }
        }

        return closest;
    }
};