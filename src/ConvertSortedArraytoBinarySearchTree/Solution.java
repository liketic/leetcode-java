package ConvertSortedArraytoBinarySearchTree;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 */
class Solution {

    private TreeNode buildBST(int[] nums, int fromIndex, int endIndex) {
        if (endIndex < fromIndex)
            return null;
        int mid = fromIndex + (endIndex - fromIndex) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, fromIndex, mid - 1);
        root.right = buildBST(nums, mid + 1, endIndex);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
}