#include <stdio.h>

#define MAX_M 100

//the index is current value after the addition
//the value is the count of the numbers
int dp[MAX_M];

int main() {
    int m, n, i;
    scanf("%d %d", &m, &n);
    int inputList[MAX_M];//store numbers for handling reversely
    for (i = 0; i < n; i++) {
        scanf("%d", &inputList[i]);
    }
    int list[MAX_M], ln = 0;//a collection to store the value that not equals with 0
    int x, j, end, p, soluable = 0;
    for (i = n - 1; i >= 0; i--) {
        x = inputList[i];
        end = ln;
        for (j = 0; j < end; j++) {//plus with others
            p = list[j] + x;
            if (dp[p] == 0) {
                dp[p] = dp[p - x] + 1; //p-x equals with list[j]
                list[ln++] = p;
            }
        }
        if (dp[x] == 0) {//store itself
            dp[x] = 1;
            list[ln++] = x;
        }
        if (dp[m]) {
            soluable = 1;
            printf("%d\n", dp[m]);
            break;
        }
    }
    if (!soluable) {
        printf("0\n");
    }
    return 0;
}
