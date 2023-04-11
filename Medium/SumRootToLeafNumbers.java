/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 0);
    }

    public int helper(TreeNode root, int currSum) {
        currSum *= 10;
        currSum += root.val;
        if (root.right == null && root.left == null) {
            return currSum;
        } else if (root.left == null) {
            return helper(root.right, currSum);
        } else if (root.right == null) {
            return helper(root.left, currSum);
        }
        return helper(root.left, currSum) + helper(root.right, currSum);
    }
}