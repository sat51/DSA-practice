class Solution {
    public int rob(int[] nums) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        return maxSum(nums, 0,memo);
    }

    private int maxSum(int[] nums,int currentHouse,HashMap<Integer,Integer> memo){
        if(currentHouse >= nums.length)
            return 0;

        if(memo.containsKey(currentHouse))    
            return memo.get(currentHouse);

        int jump1 = nums[currentHouse] + maxSum(nums,currentHouse+2,memo);
        int jump2 = maxSum(nums,currentHouse+1,memo);

        memo.put(currentHouse,Math.max(jump1,jump2));

        return Math.max(jump1,jump2);
    }
}