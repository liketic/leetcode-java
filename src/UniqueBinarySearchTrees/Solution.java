package UniqueBinarySearchTrees;


/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 */
class Solution {

    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = count[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                count[i] += count[j - 1] * count[i - j];
            }
        }
        return count[n];
    }
}