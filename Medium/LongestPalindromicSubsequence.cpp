#include <string>
#include <vector>

using namespace std;

class Solution
{
public:
    int longestPalindromeSubseq(string s)
    {
        if (s.size() == 1)
        {
            return 1;
        }
        string rev_s = "";
        for (int i = s.size() - 1; i >= 0; i--)
        {
            rev_s += s[i];
        }
        return longestCommonSubseq(s, rev_s);
    }

    int longestCommonSubseq(string s, string rev_s)
    {
        vector<vector<int>> vec;
        for (int i = 0; i <= s.size(); i++)
        {
            vector<int> temp_vec;
            for (int j = 0; j <= s.size(); j++)
            {
                temp_vec.push_back(-1);
            }
            vec.push_back(temp_vec);
        }
        for (int i = 0; i <= s.size(); i++)
        {
            vec[i][0] = 0;
            vec[0][i] = 0;
        }
        for (int i = 1; i <= s.size(); i++)
        {
            for (int j = 1; j <= s.size(); j++)
            {
                if (s[i - 1] == rev_s[j - 1])
                {
                    vec[i][j] = vec[i - 1][j - 1] + 1;
                }
                else
                {
                    int left = vec[i - 1][j];
                    int right = vec[i][j - 1];
                    int higher = left;
                    if (right > higher)
                    {
                        higher = right;
                    }
                    vec[i][j] = higher;
                }
            }
        }
        return vec[s.size()][s.size()];
    }
};