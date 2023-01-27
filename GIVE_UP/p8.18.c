#include <stdio.h>

void printAns(int arr[],int n){
	int i;
	for(i=0;i<n;i++){
		printf(" %d",arr[i]);
	}
//	for(i=n-1;i>=0;i--){
//		printf("%d",arr[i]);
//	}
}

int main(){
	int i,j;
	const int M = 40;
	int arr[128]={0};
	arr[0]=1;
	int n=1;
	for(i=1;i<=M;i++){
		for(j=0;j<n;j++){
			arr[j]*=i;
		}
		for(j=0;j<n;j++){
			if(arr[j]>=10){
				arr[j+1]+=arr[j]/10;
				arr[j]=arr[j]%10;
			}
		}
		if(arr[n]>0 && arr[n]<10){
			n++;
		}else{
			while(arr[n]>=10){
				arr[n+1]+=arr[n]/10;
				arr[n]=arr[n]%10;
				n++;
			}
		}
		printf("%4d! = ",i);
		printAns(arr,n);
		printf("\n");
	}
	
	return 0;
}
