public class Main {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1, n = prices.length, pre = prices[0], now; i < n; i++) {
            now = prices[i];
            max += now > pre ? now - pre : 0;
            pre = now;
        }
        return max;
    }
}
