#include <stdio.h>

#define N 12

int dp[20];

int fib(int n){
	if(!dp[n]){
		dp[n] = fib(n-1) + fib(n-2);
	}
	return dp[n];
}


int main(){
	dp[1]=1;
	dp[2]=2;
	int d=fib(N+1);
	printf("%d\n",d);
	return 0;
}
