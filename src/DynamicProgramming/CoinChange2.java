package DynamicProgramming;

import java.util.Arrays;

/*
You are given coins of different denominations and a total amount of money. Write a function to compute the number of
combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 */
public class CoinChange2 {

    private static int naiveChange(int amount, int[] coins) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;

        int totalCombinations = 0;

        for (int coin : coins) {
            int leftOver = amount - coin;
            totalCombinations += naiveChange(leftOver, coins);
        }

        return totalCombinations;
    }

    private static int tabulatedChange(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);

        dp[0] = 1;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int index = i - coins[j];
                if (index >= 0) dp[i] += dp[i - coins[j]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        //int[] coins = {2};
        //int amount = 3;

        int naiveOutput = naiveChange(amount, coins);
        int tabulatedApproach = tabulatedChange(amount, coins);

        System.out.println("Naive output: " + naiveOutput);
        System.out.println("Tabulated output: " + tabulatedApproach);
    }
}
