#include <cstdio>

int main() {
	char s[10002], c;//gets����\n,����һ��10000λ+\n\0=100002 
	while (fgets(s, 10002, stdin)) {
		bool a[127] = { false };//ascii 0000 0000 ~ 0111 1111
		while ((c = getchar()) != '\n') a[c] = true;
		for (char* p = s; *p != '\0'; p++) {
			if (!a[c = *p]) printf("%c", c);
		}
	}
	return 0;
}
