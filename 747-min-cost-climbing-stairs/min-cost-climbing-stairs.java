class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return Math.min(solve(n - 1, cost, memo), solve(n - 2, cost, memo));
    }

    private int solve(int n, int[] cost, int[] memo){
        // Base Case: Agar hum 0th ya 1st step par hain, toh wahan se shuru karne ki cost wahi step ki cost hogi.
        if (n < 0)  return 0;
        
        if (n == 0 || n== 1){
            return cost[n];
        }

        // Agar pehle se calculated hai, toh wahi utha lo (Memoization)
        if (memo[n] != -1) {
            return memo[n];
        }

        // Current step cost + pichle dono steps ka minimum
        memo[n] = cost[n] + Math.min(solve(n - 1, cost, memo), solve(n - 2, cost, memo));

        return memo[n];
    }
}