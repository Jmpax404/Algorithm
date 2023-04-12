#define _CRT_SECURE_NO_WARNINGS 1

#include <cstdio>

int main202212301304() {
	int n,s=0;
	scanf("%d",&n);
	while (n > 1) {
		if (n % 2 == 0) {
			n /= 2;
		}
		else {
			n = (n * 3 + 1) / 2;
		}
		s++;
	}
	printf("%d\n",s);
	return 0;
}