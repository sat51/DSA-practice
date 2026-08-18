class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
        }

        
        Boolean[][] dp = new Boolean[nums.length][(sum/2)+1];
        if(sum%2!=0)
            return false;
        else
            return checkPartition(nums,0,sum/2,dp); 
    }

    private boolean checkPartition(int[] nums,int currentIndex,int targetSum,Boolean[][] dp){
        if(targetSum == 0)
            return true;

        if(currentIndex >= nums.length)
            return false;

        boolean consider = false;

        if(dp[currentIndex][targetSum] != null) 
            return dp[currentIndex][targetSum];

        if(nums[currentIndex]<=targetSum )
            consider = checkPartition(nums,currentIndex+1,targetSum - nums[currentIndex],dp);


       boolean notConsider = checkPartition(nums,currentIndex+1,targetSum,dp);

       dp[currentIndex][targetSum] = consider || notConsider;

       return consider || notConsider;
    }
}