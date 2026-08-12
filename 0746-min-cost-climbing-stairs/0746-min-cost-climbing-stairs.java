class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        return Math.min(minCost(cost,0,memo),memo.get(1));
    }

    private int minCost(int[] arr,int index,HashMap<Integer,Integer> memo){
        if(index == arr.length){
            return 0;
        }
        if(index > arr.length){
            return 1001;
        }

        if(memo.containsKey(index))
            return memo.get(index);

        int jump1 = arr[index] + minCost(arr,index+1,memo);
        int jump2 = arr[index] + minCost(arr,index+2,memo);

        memo.put(index,Math.min(jump1,jump2));
        return memo.get(index);

    }
}