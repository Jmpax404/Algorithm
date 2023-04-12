#define _CRT_SECURE_NO_WARNINGS 1

#include <cstdio>
#include <cstring>

int main774321() {
	char s[100];
	int bs[50], ls[50], si = 0;
	fgets(s, 100,stdin);
	int n = strlen(s)-1;
	bs[si] = 0;
	for (int i = 0; i < n; i++) {
		if (s[i] == ' ') {
			ls[si] = i;
			si++;
			bs[si] = i + 1;
		}
	}
	ls[si++] = n;
	for (int i = si - 1; i >= 0;i--) {
		for (int j = bs[i]; j < ls[i];j++) {
			putchar(s[j]);
		}
		if (i > 0) {
			putchar(' ');
		}
		else{
			putchar('\n');
		}
	}
	return 0;
}