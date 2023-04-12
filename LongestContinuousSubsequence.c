#include <stdio.h>
#include <math.h>

int main(){
	int n;
	scanf("%d",&n);
	int arr[n];
	int i;
	for(i=0;i<n;i++){
		scanf("%d",&arr[i]);
	}
	int dp[n];
	dp[0]=arr[0];
	int maxval=-1<<31;
	for(i=1;i<n;i++){
		dp[i]=fmax(dp[i-1]+arr[i],arr[i]);
		if(dp[i]>maxval) maxval=dp[i];
	}
	printf("%d\n",maxval);
	return 0;
}
