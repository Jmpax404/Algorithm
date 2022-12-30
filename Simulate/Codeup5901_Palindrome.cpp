#define _CRT_SECURE_NO_WARNINGS 1

#include <cstdio>
#include <cstring>

int mainup9Z8QWzjr3u4ijj90B() {
	char s[256];
	scanf("%s", s);
	int n = strlen(s);
	int nh = n / 2;
	for (int i = 0; i < nh; i++) {
		if (s[i] != s[n - 1 - i]) {
			printf("NO\n");
			return 0;
		}
	}
	printf("YES\n");
	return 0;
}