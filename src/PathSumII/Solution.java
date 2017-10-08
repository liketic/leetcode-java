package PathSumII;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given
 * sum.
 *
 * For example: Given the below binary tree and sum = 22,
 * <pre>
 *          5
 *         / \
 *        4   8
 *       /   / \
 *      11  13  4
 *     /  \    / \
 *    7    2  5   1
 * </pre>
 * return
 * <pre>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * </pre>
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {

    private List<List<Integer>> pathSumFromRoot(TreeNode root, int sum, int[] path, int n) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;

        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                if (n >= path.length) {
                    int[] newPath = new int[n + 1];
                    System.arraycopy(path, 0, newPath, 0, n);
                    path = newPath;
                }
                path[n++] = sum;
                List<Integer> asList = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    asList.add(path[i]);
                }
                paths.add(asList);
                return paths;
            }
            return paths;
        }
        sum -= root.val;

        if (n >= path.length) {
            int[] newPath = new int[(n + 1) * 2];
            System.arraycopy(path, 0, newPath, 0, n);
            path = newPath;
        }
        path[n++] = root.val;

        List<List<Integer>> leftPaths = pathSumFromRoot(root.left, sum, path, n);
        List<List<Integer>> rightPaths = pathSumFromRoot(root.right, sum, path, n);
        rightPaths.addAll(leftPaths);

        return rightPaths;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return pathSumFromRoot(root, sum, new int[4], 0);
    }
}