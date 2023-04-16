#include <stdio.h>

int func(int arr[],int n,int r){
	int res=0;
	for(int i=0;i<n;i++){
		res+=arr[i]/r;
	}
	return res;
}

int myMax(int arr[],int n){
	int maxValue=0;
	for(int i=0;i<n;i++){
		if(arr[i]>maxValue){
			maxValue=arr[i];
		}
	}
	return maxValue;
}

int bs(int arr[],int n, int k){
	int left=1;
	int right=myMax(arr,n);
	int mid,t;
	while(left<right){
		mid=left + (right-left)/2;
		if(func(arr,n,mid)<k){
			right=mid;
		}else{
			left=mid+1;
		}
	}
	return left-1;
}

/*
3 7
10 24 15
*/
int main(){
	int n,k;
	scanf("%d %d",&n,&k);
	int arr[n];
	for(int i=0;i<n;i++){
		scanf("%d",&arr[i]);
	}
	int r;
	int res=bs(arr,n,k);
	printf("%d\n",res);
	return 0;
}
