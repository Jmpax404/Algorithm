#include<stdio.h>

int arr[501];

int main() {
    int n;
    scanf("%d", &n);
    int d;
    for (int i = 0; i < n; i++) {
        scanf("%d", &d);
        arr[d]++;
    }
    for (int i = 1; i <= 500; i++) {
        if (arr[i] > 0) {
            printf("%d\n", i);
        }
    }
    return 0;
}
