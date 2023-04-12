#define _CRT_SECURE_NO_WARNINGS 1

#include <cstdio>

int mainhpQeGDjJlnlUbUh2xT() {
	int a, b, d;
	scanf("%d%d%d", &a, &b, &d);
	int c = a + b;
	int arr[32], n = 0;
	do {
		arr[n++] = c % d;
		c /= d;
	} while (c != 0);
	while (--n>=0) {
		printf("%d",arr[n]);
	}
	printf("\n");
	return 0;
}