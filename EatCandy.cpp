#include <stdio.h>

int dp[20]={-1,1,2};

int fib(int n){
	if(n<=2){
		return n;
	}
	if(dp[n]!=0){
		return dp[n];
	}
	dp[n]=fib(n-1)+fib(n-2);
	return dp[n];
} 

int main(){
	int n;
	while(scanf("%d",&n)!=EOF){
		printf("%d\n",fib(n));
	}
	return 0;
}
