#define _CRT_SECURE_NO_WARNINGS 1

#include <cstdio>

int a[] = { 2,4,5,6,3,1 };
int n = 6;

void selectSort() {
	for (int i = 0; i < n; i++) {
		int k = i;
		int kv = a[i];
		for (int j = i; j < n; j++) {
			if (a[j] < kv) {
				k = j;
				kv = a[j];
			}
		}
		a[k] = a[i];
		a[i] = kv;
	}
}

void insertSort() {
	for (int i = 1; i < n; i++) {
		int j = i;
		int v = a[i];
		while (j > 0 && v < a[j - 1]) {
			a[j] = a[j - 1];
			j--;
		}
		a[j] = v;
	}
}

int main75891051() {
	//selectSort();
	insertSort();
	for (int i = 0; i < n; i++) {
		printf(" %d", a[i]);
	}
	return 0;
}