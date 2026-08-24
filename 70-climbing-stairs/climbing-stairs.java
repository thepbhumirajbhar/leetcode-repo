class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1]; 
        Arrays.fill(memo, -1);
        return solve(n, memo);
    }

    private int solve(int n, int[] memo){
        // Base case
        if(n <= 2) return n;

        // Agar pehle se calculate kiya hua hai, toh direct wahi return kar do
        if(memo[n] != -1) return memo[n];

        // Warna calculate karke memo array mein store kar lo
        memo[n] = solve(n-1, memo) + solve(n-2, memo);
        return memo[n];
    }
}