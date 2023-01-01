#define _CRT_SECURE_NO_WARNINGS 1

#include <cstdio>
#include <algorithm>

using namespace std;

typedef _int64 MyLong;

typedef struct {
	MyLong num;
	int score;
	int loc;
	int rank;
} Student;

bool compare1(Student s1, Student s2) {
	if (s1.score != s2.score) return s1.score > s2.score;
	else return s1.num < s2.num;
}

int main() {
	int m, n;
	Student b[30000];
	int bn = 0;
	scanf("%d", &m);
	for (int i = 1; i <= m; i++) {
		scanf("%d", &n);
		MyLong num; int score;
		for (int j = 0; j < n; j++) {
			scanf("%lld %d", &num, &score);
			b[bn].num = num;
			b[bn].score = score;
			b[bn].loc = i;
			bn++;
		}
		sort(b + bn - n, b + bn, compare1);
		int r = 1;
		b[bn - n].rank = 1;
		for (int j = bn - n + 1; j < bn; j++) {
			if (b[j].score != b[j - 1].score) {
				r = j-(bn - n) + 1;
			}
			b[j].rank = r;
		}
	}
	sort(b, b + bn, compare1);
	//print
	printf("%d\n", bn);
	int r = 1;
	for (int i = 0; i < bn; i++) {
		if (i > 0 && b[i].score != b[i - 1].score) {
			r = i + 1;
			
		}
		printf("%013lld %d %d %d\n", b[i].num, r, b[i].loc, b[i].rank);
	}
	return 0;
}