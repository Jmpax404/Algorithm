#define _CRT_SECURE_NO_WARNINGS 1

#include <cstdio>

int maincMcM2xOjf3qkKQoxp58() {
	int n;
	char c;
	scanf("%d %c", &n, &c);
	int h = n % 2 ? n + 1 : n;
	h = h / 2 - 2;
	for (int i = 0; i < n; i++) putchar(c);
	putchar('\n');
	for (int i = 0; i < h; i++) {
		putchar(c);
		for (int j = 2; j < n; j++) {
			putchar(' ');
		}
		putchar(c); putchar('\n');
	}
	for (int i = 0; i < n; i++) putchar(c);
	putchar('\n');
	return 0;
}