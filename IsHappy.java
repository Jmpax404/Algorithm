public class Solution {
    public boolean isHappy(int n) {
        boolean[] hash = new boolean[1024];
        while (n != 1) {
            int a = n;
            int sum = 0;
            while (a != 0) {
                int t = a % 10;
                sum += t * t;
                a /= 10;
            }
            n = sum;
            if (hash[n]) {
                return false;
            } else {
                hash[n] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
