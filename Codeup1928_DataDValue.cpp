#define _CRT_SECURE_NO_WARNINGS 1

#include <cstdio>

inline int isLeap(int year) {
	return (year % 4 == 0 && year % 100) || (year % 400 == 0);
}

int main() {
	int M[13] = { 0,31,28,31,30,31,30,31,31,30,31,30,31 };
	int t1, t2;
	int y1, y2, m1, m2, d1, d2;
	while (scanf("%d%d", &t1, &t2) != EOF) {
		if (t1 > t2) {//不判断通过不了
			int t = t1;
			t1 = t2;
			t2 = t;
		}
		//fetch YYYY MM DD
		/*
		{
			char y1s[5], y2s[5], m1s[3], m2s[3], d1s[3], d2s[3];
			for (int i = 0; i < 4; i++) {
				y1s[i] = t1[i];	y2s[i] = t2[i];
			}
			y1s[4] = '\0'; y2s[4] = '\0';
			for (int i = 0; i < 2; i++) {
				m1s[i] = t1[i + 4]; m2s[i] = t2[i + 4]; d1s[i] = t1[i + 6]; d2s[i] = t2[i + 6];
			}
			m1s[2] = '\0'; m2s[2] = '\0'; d1s[2] = '\0'; d2s[2] = '\0';
			sscanf(y1s, "%d", &y1); sscanf(y2s, "%d", &y2);
			sscanf(m1s, "%d", &m1); sscanf(m2s, "%d", &m2);
			sscanf(d1s, "%d", &d1); sscanf(d2s, "%d", &d2);
		}
		*/
		y1 = t1 / 10000, m1 = t1 % 10000 / 100, d1 = t1 % 100;
		y2 = t2 / 10000, m2 = t2 % 10000 / 100, d2 = t2 % 100;
		int day1 = d1, day2 = d2, isrun1 = 0;
		//计算距离该年的开始有多少天
		{
			for (int i = 1; i < m1; i++) {
				day1 += M[i];
			}
			isrun1 = isLeap(y1);
			if (m1 > 2 && isrun1) day1 += 1;
			for (int i = 1; i < m2; i++) {
				day2 += M[i];
			}
			if (m2 > 2 && isLeap(y2)) day2 += 1;
		}
		//计算差额
		{
			int diff = y2 - y1 - 1;
			if (diff == -1) {//2022 2022
				printf("%d\n", day2 - day1 + 1);
			}
			else {//2022 2023/2024
				int total = 0, ynow;
				total += isrun1 ? 366 - day1 : 365 - day1;
				for (int i = 0; i < diff; i++) {
					ynow = y1 + i;
					total += isLeap(ynow) ? 366 : 365;
				}
				total += day2 + 1;
				printf("%d\n", total);
			}
		}
	}
	return 0;
}