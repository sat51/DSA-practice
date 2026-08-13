class Solution {
    public int tribonacci(int n) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        return nthNum(n,memo);
    }

    private int nthNum(int n,HashMap<Integer,Integer> memo){
        if(n == 2 || n==1){
            return 1;
        }
        if(n==0)
            return 0;

        int currentKey = n;
        if(memo.containsKey(currentKey))    
            return memo.get(currentKey);

        int way1 = nthNum(n-1,memo);
        int way2 = nthNum(n-2,memo);
        int way3 = nthNum(n-3,memo);

        memo.put(currentKey,(way1+way2+way3));

        return memo.get(currentKey);
    }
}