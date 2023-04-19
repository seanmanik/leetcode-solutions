/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution
{
public:
    unordered_map<TreeNode *, unordered_map<bool, int>> set;
    int longestZigZag(TreeNode *root)
    {
        if (root == NULL)
        {
            return 0;
        }
        int leftAns = helper(root->left, true, 0);
        int rightAns = helper(root->right, false, 0);
        if (leftAns > rightAns)
        {
            return leftAns;
        }
        return rightAns;
    }

    int helper(TreeNode *root, bool isLeft, int curr)
    {
        if (root == NULL)
        {
            return curr;
        }
        if (set.find(root) != set.end())
        {
            if (set[root].find(isLeft) != set[root].end())
            {
                return set[root][isLeft];
            }
        }
        if (isLeft)
        {
            int nextMove = helper(root->right, false, curr + 1);
            int alternative = longestZigZag(root);
            if (nextMove > alternative)
            {
                set[root][isLeft] = nextMove;
                return nextMove;
            }
            set[root][isLeft] = alternative;
            return alternative;
        }
        else
        {
            int nextMove = helper(root->left, true, curr + 1);
            int alternative = longestZigZag(root);
            if (nextMove > alternative)
            {
                set[root][isLeft] = nextMove;
                return nextMove;
            }
            set[root][isLeft] = alternative;
            return alternative;
        }
    }
};