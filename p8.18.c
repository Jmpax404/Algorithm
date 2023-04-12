#include <stdio.h>

void printAns(int arr[],int n,int c){
	printf("%4d! = ",c);
	int i;
	for(i=n-1;i>=0;i--){
		printf("%d",arr[i]);
	}
	printf("\n");
}

int main(){
	int i,j,t;
	const int M = 40;
	int arr[256]={0};
	arr[0]=1;
	int n=1;
	int m;
	for(i=1;i<=M;i++){
		m=0;
		for(j=0;j<n;j++){
			t=arr[j]*i+m;
			arr[j]=t%10;
			m=t/10;
		}
		while(m>0){
			arr[j]=m%10;
			m/=10;
			j++;
		}
		n=j;
		printAns(arr,n,i);
	}
	return 0;
}
