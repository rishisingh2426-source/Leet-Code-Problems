import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] stores the minimum coins needed to make up amount i
        int[] dp = new int[amount + 1];
        
        // Fill array with a default value higher than any possible answer (amount + 1)
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 amount requires 0 coins
        dp[0] = 0;
        
        // Compute minimum coins for every sub-amount from 1 to amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        
        // If dp[amount] wasn't updated, the amount cannot be formed
        return dp[amount] > amount ? -1 : dp[amount];
    }
}