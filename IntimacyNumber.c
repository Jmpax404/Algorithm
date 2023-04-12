#include <stdio.h>
#include <string.h>

int calSum(int x){
	int i;
	int sum=0;
	for(i=1;i<x;i++){
		if(x%i==0){
			sum+=i;
		}
	}
	return sum;
}

int main(){
	int arr[5000];
	memset(arr,0,sizeof(arr));
	int i;
	int n=3000;
	for(i=2;i<=n;i++){
		arr[i]=calSum(i);
	}
	for(i=2;i<=n;i++){
		int t=arr[i];
		if(t>i && t<n && arr[t]==i){
			printf("(%d,%d)\n",i,t);
		}
	}
	return 0;
}
