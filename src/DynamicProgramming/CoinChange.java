package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing
a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    private static int naiveCoinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int leftOver = amount - coin;
            int childCoinChange = naiveCoinChange(coins, leftOver);

            // Impossible for this child to get amount
            if (childCoinChange != -1) {
                childCoinChange++;
            }

            // Update minimum if child coin change min is not -1 only
            if (childCoinChange != -1) {
                minCoins = Math.min(minCoins, childCoinChange);
            }

        }

        // if suitable coin not found, then not possible to get amount, return -1
        if (minCoins == Integer.MAX_VALUE) return -1;
        return minCoins;
    }

    private static int memoCoinChange(int[] coins, int amount) {
        return memoCoinChangeHelper(coins, amount, new HashMap<>());
    }

    private static int memoCoinChangeHelper(int[] coins, int amount, Map<Integer, Integer> map) {
        if (map.containsKey(amount)) return map.get(amount);
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int leftOver = amount - coin;
            int childCoinChange = memoCoinChangeHelper(coins, leftOver, map);

            // Impossible for this child to get amount
            if (childCoinChange != -1) {
                childCoinChange++;
            }

            // Update minimum if child coin change min is not -1 only
            if (childCoinChange != -1) {
                minCoins = Math.min(minCoins, childCoinChange);
            }

        }

        // if suitable coin not found, then not possible to get amount, return -1
        if (minCoins == Integer.MAX_VALUE) {
            map.put(amount, -1);
            return -1;
        }
        map.put(amount, minCoins);
        return minCoins;
    }

    private static int tabulatedCoinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0; // base case
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int leftOver = i - coins[j];
                if (leftOver >= 0 && dp[leftOver] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[leftOver]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        //int[] coins = {1, 2, 5};
        //int amount = 11;
        int[] coins = {2};
        int amount = 3;

        //int[] coins = {1, 2, 5};
        //int amount = 100;

        //int naiveOutput = naiveCoinChange(coins, amount);
        int memoOutput = memoCoinChange(coins, amount);
        int tabulatedOutput = tabulatedCoinChange(coins, amount);

        System.out.println("Memoized output: " + memoOutput);
        System.out.println("Tabulated output: " + tabulatedOutput);
    }
}
