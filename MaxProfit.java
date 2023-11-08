public class Main {
    static class Solution {
        public int maxProfit(int[] prices) {
            int minBefore = prices[0];
            int maxGain = 0;
            for (int i = 1, n = prices.length, t, pn; i < n; i++) {
                if ((t = (pn = prices[i]) - minBefore) > 0) {
                    maxGain = Math.max(t, maxGain);
                } else {// decrease an if statement by increasing a register assignment
                    minBefore = pn;
                }
            }
            return maxGain;
        }
    }

    public static void main(String[] args) {

    }
}