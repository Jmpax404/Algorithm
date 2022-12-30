#define _CRT_SECURE_NO_WARNINGS 1

# include <cstdio>

int d[100001];

int mainUbEObqHFuaOdWS1h() {
	int n;
	int ci, cs;
	int mi = 0, ms = -1;
	scanf("%d", &n);
	while (n--){
		scanf("%d%d",&ci,&cs);
		d[ci] += cs;
		if(d[ci]>ms){
			mi = ci;
			ms = d[mi];
		}
	}
	printf("%d %d\n",mi, ms);
	return 0;
}