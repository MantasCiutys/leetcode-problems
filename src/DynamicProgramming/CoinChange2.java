package DynamicProgramming;
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

    public static void main(String[] args) {
        //int[] coins = {1, 2, 5};
        //int amount = 5;

        int[] coins = {2};
        int amount = 3;

        int naiveOutput = naiveChange(amount, coins);

        System.out.println("Naive output: " + naiveOutput);
    }
}
