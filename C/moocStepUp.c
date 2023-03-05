#include <stdio.h>

int dp[101];

int f(int x){
	if(dp[x]==0){
		dp[x]=f(x-2)+f(x-1);
	}
	return dp[x];
}

int main(){
	dp[0]=-1;
	dp[1]=1;
	dp[2]=2;
	printf("%d\n",f(10));
	return 0;
}
