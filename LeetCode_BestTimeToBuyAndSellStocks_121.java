class Solution {

    public int maxProfit(int[] prices) {
        // return newMaxSell(prices);
        return linear(prices);
        // return arrayPreComputation(prices);
        // return bruteForce(prices);
    }

    // Prafull - 2023 - TC = O(n) SC = O(1)
    // Keeping track of min value, and then calculating profit with each of i value and min value.
    public int linear(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }

        return profit;
    }

    // TC = O(n) SC = O(n)
    public int arrayPreComputation(int[] p) {
        if (p.length == 0) return 0;

        int[] maxVals = new int[p.length];
        int largerFromRight = p[p.length - 1];
        int maxProfit = 0;

        for (int i = p.length - 2; i >= 0; i--) {
            if (p[i] > largerFromRight) {
                maxVals[i] = largerFromRight = p[i];
            } else {
                maxVals[i] = largerFromRight;
            }
        }

        for (int i = 0; i < p.length; i++) {
            int profit = maxVals[i] - p[i];
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    // TC = O(n^2) SC = O(1)
    public int bruteForce(int[] prices) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int curProfit = prices[j] - prices[i];
                max = Math.max(curProfit, max);
            }
        }

        return max;
    }

    /* 
        Desc - Keeping track of the max values from the right, will have an edge
        space - O(n)
        time - O(n)
        
    */
    public int newMaxSell(int[] prices) {
        int profit = 0;
        int length = prices.length;
        int[] maxSellingPrice = new int[length];

        maxSellingPrice[length - 1] = prices[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            maxSellingPrice[i] = Math.max(prices[i], maxSellingPrice[i + 1]);
        }

        for (int i = 0; i < length; i++) {
            profit = Math.max(profit, maxSellingPrice[i] - prices[i]);
        }

        return profit;
    }

    // TC = O(n) SC = O(n)
    public int newMethod(int[] prices) {
        int len = prices.length;
        int[] preCompute = new int[len];
        int profit = 0;

        preCompute[len - 1] = prices[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            preCompute[i] = Math.max(preCompute[i], preCompute[i + 1]);
        }

        for (int i = 0; i < len; i++) {
            int curProfit = preCompute[i] - prices[i];
            profit = Math.max(profit, curProfit);
        }

        return profit;
    }
}
