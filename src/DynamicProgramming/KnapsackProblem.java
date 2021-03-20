package DynamicProgramming;

/*
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value
in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and
weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the
maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot
break an item, either pick the complete item or don’t pick it (0-1 property).
 */
public class KnapsackProblem {
    private static int naiveMaxValue(int[] values, int[] weights, int w) {
        if (w == 0) return 0;

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < weights.length; i++) {
            int leftWeight = w - weights[i];
            //int remainingValue = naiveMaxValue(values, weights, leftWeight);
            if (leftWeight >= 0) {
                maxValue = Math.max(maxValue, values[i] + naiveMaxValue(values, weights, leftWeight));
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int w = 50;

        int naiveOutput = naiveMaxValue(values, weights, w);

        System.out.println(naiveOutput);
    }
}
