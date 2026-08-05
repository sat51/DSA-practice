class Solution {
    public int climbStairs(int n) {
        return possibleWays(0,n,new HashMap<Integer,Integer>());  
    }

    private int possibleWays(int currentStair ,int targetStair,HashMap<Integer,Integer> memo){
            if(currentStair == targetStair)
                return 1;

             if(currentStair > targetStair)
                return 0;

            int currentKey  = currentStair;

            if(memo.containsKey(currentKey))
                return memo.get(currentKey);

             int oneJump = possibleWays(currentStair+1,targetStair,memo);

             int twoJump = possibleWays(currentStair+2,targetStair,memo);

             memo.put(currentKey,(oneJump+twoJump));

             return oneJump+twoJump;
        }
}