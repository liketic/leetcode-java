package MaximumSumof3Non_OverlappingSubarrays;


class Solution {


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sumFromLeft = new int[n];
        int[] sumFromRight = new int[n];
        int[] maxFromLeft = new int[n];
        int[] maxFromRight = new int[n];

        for (int i = 0; i < n; i++) {
            sumFromLeft[i] = nums[i] + (i == 0 ? 0 : sumFromLeft[i - 1]);
            maxFromLeft[i] = -1;

            if (i - k + 1 >= 0) {
                if (i == 0) {
                    maxFromLeft[i] = i;
                    continue;
                }
                int j = maxFromLeft[i - 1];
                if (j == -1) {
                    maxFromLeft[i] = i;
                    continue;
                }
                int x = sumFromLeft[j] - (j - k >= 0 ? sumFromLeft[j - k] : 0);
                int y = sumFromLeft[i] - (i - k >= 0 ? sumFromLeft[i - k] : 0);
                if (y > x) {
                    maxFromLeft[i] = i;
                } else {
                    maxFromLeft[i] = maxFromLeft[i - 1];
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            sumFromRight[i] = nums[i] + (i == n - 1 ? 0 : sumFromRight[i + 1]);

            if (i + k - 1 < n) {
                if (i == n - 1) {
                    maxFromRight[i] = i;
                    continue;
                }
                int j = maxFromRight[i + 1];
                if (j == -1) {
                    maxFromRight[i] = i;
                    continue;
                }
                int x = sumFromRight[j] - (j + k < n ? sumFromRight[j + k] : 0);
                int y = sumFromRight[i] - (i + k < n ? sumFromRight[i + k] : 0);

                if (y >= x) {
                    maxFromRight[i] = i;
                } else {
                    maxFromRight[i] = maxFromRight[i + 1];
                }
            } else {
                maxFromRight[i] = -1;
            }
        }

        int maxSum = -1;
        int[] rx = new int[3];

        for (int i = 0; i < n; i++) {
            if (i - k >= k - 1 && i + k < n) {
                int l = maxFromLeft[i - k];
                if (l == -1) continue;
                int r = maxFromRight[i + 1];
                if (r == -1) continue;

                int sum = 0;
                sum += sumFromLeft[l] - (l >= k ? sumFromLeft[l - k] : 0);
                sum += sumFromRight[r] - (r + k < n ? sumFromRight[r + k] : 0);
                sum += sumFromLeft[i] - sumFromLeft[i - k];

                if (sum > maxSum) {
                    rx[0] = l - k + 1;
                    rx[1] = i - k + 1;
                    rx[2] = r;
                    maxSum = sum;
                }
            }
        }

        return rx;
    }
}