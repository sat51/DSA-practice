class Solution {
    public int fib(int n) {
       return nFib(n, new HashMap<Integer,Integer>());
    }

    private int nFib(int n,HashMap<Integer,Integer> memo){
        if(n==0)
        return 0;

        if(n==1)
        return 1;

        if(memo.containsKey(n))
        return memo.get(n);

        int firstNumber = nFib(n-1,memo);
        int secondNumber = nFib(n-2,memo);

        memo.put(n,(firstNumber+secondNumber));

        return firstNumber + secondNumber;
    }
}