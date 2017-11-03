package _4Sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d =
 * target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note: The Solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A Solution set is: [ [-1,  0, 0, 1], [-2, -1, 1, 2], [-2,  0, 0, 2] ]
 */
class Solution {

    private static class Node {
        int i;
        int j;
        int v;
        int vi, vj;

        Node(int i, int j, int vi, int vj) {
            this.i = i;
            this.j = j;
            this.vi = vi;
            this.vj = vj;
            this.v = vi + vj;
        }

        boolean hasIntersection(Node other) {
            return (i == other.i || i == other.j || j == other.i || j == other.j);
        }
    }

    private static boolean listEqual(List<Integer> a, List<Integer> b) {
        for (int i = 0, n = a.size(); i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfExist(List<List<Integer>> resultSet, List<Integer> item) {
        return resultSet.stream().anyMatch(it -> listEqual(it, item));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        Node[] nodes = new Node[n * n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                nodes[size++] = new Node(i, j, nums[i], nums[j]);
            }
        }

        Arrays.sort(nodes, 0, size, (o1, o2) -> {
            if (o1.v == o2.v) {
                if (o1.i == o2.i) {
                    return Integer.compare(o1.j, o2.j);
                }
                return o1.i < o2.i ? -1 : 1;
            }
            return o1.v < o2.v ? -1 : 1;
        });

        List<List<Integer>> resultSet = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int l = i + 1, r = size - 1, m;
            int v = target - nodes[i].v;

            while (l <= r) {
                m = (l + r) / 2;
                if (nodes[m].v >= v) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

            for (int j = Math.max(l, i + 1); j < size; j++) {
                if (nodes[j].v > v) {
                    break;
                }
                if (nodes[j].v < v || nodes[i].hasIntersection(nodes[j])) {
                    continue;
                }
                List<Integer> item = Arrays.asList(nodes[i].vi, nodes[i].vj, nodes[j].vi, nodes[j].vj);
                Collections.sort(item);

                if (!checkIfExist(resultSet, item)) {
                    resultSet.add(item);
                }
            }
        }

        return resultSet;
    }
}