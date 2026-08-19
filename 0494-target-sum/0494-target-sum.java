class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // int [][] dp = new int[nums.length][];
        return maxWays(nums,target,0);
    }

    private int maxWays(int[] nums , int target, int currentIndex){
        if(currentIndex == nums.length && target == 0)
            return 1;
        
        if(currentIndex >= nums.length )
            return 0;

        int plusSign = maxWays(nums,target-nums[currentIndex],currentIndex+1);
        int negativeSign = maxWays(nums, target+nums[currentIndex],currentIndex+1);

        return plusSign + negativeSign;
    }
}