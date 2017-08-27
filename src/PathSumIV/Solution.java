package PathSumIV;


class Solution {

    private int getLevel(int n) {
        return n / 100;
    }

    private int getPostition(int n) {
        return (n % 100) / 10;
    }

    private int getValue(int n) {
        return n % 10;
    }

    public int pathSum(int[] nums) {
        int[] arr = new int[100];
        int n = 100;

        for (int i = 0; i < 100; i++)
            arr[i] = -1;

        for (int i = 0; i < nums.length; i++) {
            int l = getLevel(nums[i]);
            int p = getPostition(nums[i]);
            int v = getValue(nums[i]);

            int x = (1 << (l - 1)) + p - 1;

            arr[x] = v;
        }

//        System.out.println(Arrays.toString(arr));

        int s = 0;

        for (int i = 1; i < 100; i++) {
            int x = i * 2;
            int y = i * 2 + 1;

            if (arr[i] >= 0) {
                if ((x >= 100 || arr[x] == -1) && (y >= 100 || arr[y] == -1)) {
                    int t = i;
                    while (t > 0) {
                        s += arr[t];
                        t /= 2;
                    }
                }
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.pathSum(new int[]{113, 215, 221}));
    }
}