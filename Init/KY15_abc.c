#include <stdio.h>

int main() {
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= 9; j++) {
            for (int k = 0; k <= 9; k++) {
                if ((i + j) * 100 + (j + k) * 10 + k * 2 == 532) {
                    printf("%d %d %d\n", i, j, k);
                }
            }
        }
    }
    return 0;
}
