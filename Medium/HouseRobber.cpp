class Solution
{
public:
    vector<vector<int>> vec;
    int rob(vector<int> &nums)
    {
        int total = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            total += nums[i];
        }
        for (int i = 0; i <= nums.size() + 2; i++)
        {
            vector<int> temp;
            for (int j = 0; j <= total; j++)
            {
                temp.push_back(-1);
            }
            vec.push_back(temp);
        }
        helper(nums, 0, 0);
        return vec[0][0];
    }

    int helper(vector<int> &nums, int index, int curr)
    {
        cout << index << ", " << curr < "\n";
        if (index >= nums.size())
        {
            vec[index][curr] = curr;
            return curr;
        }
        if (vec[index][curr] != -1)
        {
            return vec[index][curr];
        }
        int take = helper(nums, index + 2, curr + nums[index]);
        int dontTake = helper(nums, index + 1, curr);
        if (take > dontTake)
        {
            vec[index][curr] = take;
            return take;
        }
        vec[index][curr] = dontTake;
        return dontTake;
    }
};