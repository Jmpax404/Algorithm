#include <stdio.h>

int dp[31];

int fib(int n){
	if(n==0 || n==1) return n;
	if(dp[n]) return dp[n];
	else return dp[n]=fib(n-1)+fib(n-2);
}

int main(){
	int n;
	scanf("%d",&n);
	printf("%d\n",fib(n));
	return 0;
}
