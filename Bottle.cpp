#include <cstdio>

int main() {
    int n;//empty bottles
    while (~scanf("%d", &n) && n != 0) {
        int d, p, total = 0;
        while (n >= 3) {
            d = n / 3;
            p = n % 3;
            total += d;
            n = d + p;
        }
        if (n == 2) total++;
        printf("%d\n", total);
    }
    return 0;
}
