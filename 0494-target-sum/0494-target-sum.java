class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for (int val : nums) {
            sum += val;
        }

        if (target > sum || target < -sum) {
            return 0;
        }

        Integer[][] dp = new Integer[nums.length][2 * sum + 1];

        return maxWays(nums, target, 0, dp, sum);
    }

    private int maxWays(
            int[] nums,
            int target,
            int currentIndex,
            Integer[][] dp,
            int sum) {

        if (currentIndex == nums.length) {
            return target == 0 ? 1 : 0;
        }

        if (target > sum || target < -sum) {
            return 0;
        }

        int updatedIndex = target + sum;

        if (dp[currentIndex][updatedIndex] != null) {
            return dp[currentIndex][updatedIndex];
        }

        int plusSign = maxWays(
                nums,
                target - nums[currentIndex],
                currentIndex + 1,
                dp,
                sum
        );

        int negativeSign = maxWays(
                nums,
                target + nums[currentIndex],
                currentIndex + 1,
                dp,
                sum
        );

        dp[currentIndex][updatedIndex] = plusSign + negativeSign;

        return dp[currentIndex][updatedIndex];
    }
}