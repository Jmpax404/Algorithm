#include <stdio.h>
#include <math.h>

#define MAXN 1000

int f[MAXN][MAXN],dp[MAXN][MAXN];
int main(){
	int n;
	scanf("%d",&n);
	int i,j;
	for(i=1;i<=n;i++){
		for(j=1;j<=i;j++){
			scanf("%d",&f[i][j]);
		}
	}
	for(i=1;i<=n;i++){
		dp[n][i]=f[n][i];
	}
	for(i=n-1;i>=1;i--){
		for(j=1;j<=n;j++){
			dp[i][j]=(int)fmax(dp[i+1][j],dp[i+1][j+1]) + f[i][j];
		}
	}
	printf("%d\n",dp[1][1]);
	return 0;
}
