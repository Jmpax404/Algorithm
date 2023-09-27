#include <stdio.h>

#define N 100010

int main(){
	int n;
	int arr[N];
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&arr[i]);
	}
	int leftMax[N];
	int rightMin[N];
	int res[N];
	int rn=0;
	leftMax[0]=arr[0];
	for(int i=1;i<n;i++){
		if(arr[i]>=leftMax[i-1]){
			leftMax[i]=arr[i];
		}else{
			leftMax[i]=leftMax[i-1];
		}
	}
	rightMin[n]=arr[n-1];
	for(int i=n-1;i>=0;i--){
		if(arr[i]<=rightMin[i+1]){	
			rightMin[i]=arr[i];
			if(arr[i]==leftMax[i]){
				res[rn++]=arr[i];
			}
		}else{
			rightMin[i]=rightMin[i+1];
		}
	}
	printf("%d\n",rn);
	if(rn>0){
		printf("%d",res[rn-1]);
		for(int i=rn-2;i>=0;i--){
			printf(" %d",res[i]);
		}
	}
	printf("\n");
	return 0;
}
