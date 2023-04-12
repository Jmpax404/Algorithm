#include <stdio.h>

void bubbleSort(int arr[],int n){
	int i,j,t;//need to optimize
	for(i=n-1;i>=1;i--){
		for(j=n-2;j>=n-i-1;j--){
			if(arr[j+1]<arr[j]){
				t=arr[j+1];
				arr[j+1]=arr[j];
				arr[j]=t;
			}
		}
	}
}

int main(){
	int arr[10]={1,5,3,8,6,2,9,3,4};
	int n=9;
	bubbleSort(arr,n);
	int i;
	for(i=0;i<n;i++){
		printf(" %d",arr[i]);
	}
	printf("\n");
	return 0;
}
