#define _CRT_SECURE_NO_WARNINGS 1

#include <cstdio>

int mainQRdNoRqeYepmhbxhe2() {
	int n, t;
	int a[300];
	int i;
	while (scanf("%d", &n)!=EOF) {
		for (i = 0; i < n; i++) {
			scanf("%d", &t);
			a[i] = t;
		}
		scanf("%d", &t);
		for (i = 0; i < n; i++) {
			if (a[i] == t) {
				printf("%d\n", i);
				break;
			}
		}
		if (i == n) {
			printf("-1\n");
		}
	}
	return 0;
}