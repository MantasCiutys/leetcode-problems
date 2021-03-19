package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
You are given a rod of size n >0, it can be cut into any number of pieces k (k ≤ n). Price for each piece of size i is
represented as p(i) and maximum revenue from a rod of size i is r(i) (could be split into multiple pieces).
Find r(n) for the rod of size n.
 */
public class RodCutting {

    // NAIVE APPROACH
    private static int naiveCutRodMaxPrice(int[] prices, int N) {
        if (N <= 0) return 0;

        int maxPrice = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            maxPrice = Math.max(maxPrice, prices[i - 1] + naiveCutRodMaxPrice(prices, N - i));
        }
        return maxPrice;
    }

    // MEMOIZED APPROACH
    private static int memoizedCutRodMaxPrice(int[] prices, int N) {
        return memoizedCutRodMaxPriceHelper(prices, N, new HashMap<>());
    }

    private static int memoizedCutRodMaxPriceHelper(int[] prices, int N, Map<Integer, Integer> memo) {
        if (memo.containsKey(N)) return memo.get(N);
        if (N <= 0) return 0;

        int maxPrice = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            maxPrice = Math.max(maxPrice, prices[i - 1] + naiveCutRodMaxPrice(prices, N - i));
        }

        memo.put(N, maxPrice);
        return maxPrice;
    }

    public static void main(String[] args) {
        int[] prices = {5, 10, 20};
        int N = 3;

        int naiveOutput = naiveCutRodMaxPrice(prices, N);
        int memoizedOutput = memoizedCutRodMaxPrice(prices, N);

        System.out.println("Naive output " + naiveOutput);
        System.out.println("Memoized output " + memoizedOutput);
    }
}
