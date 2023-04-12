#include <stdio.h>

#define SORT insertSort

void insertSort(int arr[],int n){
	int i,j,k,t;
	for(i=1;i<n;i++){
		t=arr[i];
		j=i-1;
		while(j>=0 && arr[j]>t){
		 	j--;
		}
		for(k=i-1;k>j;k--){
			arr[k+1]=arr[k];
		}
		arr[j+1]=t;
	}
}

void selectSort(int arr[],int n){
	int i,j,t,mi,mv;
	for(i=0;i<n-1;i++){
		mi=-1;
		mv=0x7FFFFFFF;
		for(j=i;j<n;j++){
			if(arr[j]<mv){
				mv=arr[j];
				mi=j;
			}
		}
		arr[mi]=arr[i];
		arr[i]=mv;
	}
}

void bubbleSort(int arr[],int n){
	int i,j,t;
	for(i=0;i<n-1;i++){//bubble from small to large
		for(j=n-2;j>=i;j--){
			if(arr[j+1]<arr[j]){
				t=arr[j],arr[j]=arr[j+1],arr[j+1]=t;
			}		
		}
	}
	for(i=n-1;i>0;i--){//bubble from small to large
		for(j=n-1;j>n-i-1;j--){
			if(arr[j]<arr[j-1]){
				t=arr[j],arr[j]=arr[j-1],arr[j-1]=t;
			}	
		}
	}
	for(i=n-1;i>0;i--){//bubble from big to small
		for(j=1;j<=i;j++){
			if(arr[j-1]>arr[j]){
				t=arr[j-1];arr[j-1]=arr[j];arr[j]=t;
			}	
		}
	}
	for(i=0;i<n-1;i++){//bubble from big to small
		for(j=0;j<n-i-1;j++){
			if(arr[j+1]<arr[j]){
				t=arr[j],arr[j]=arr[j+1],arr[j+1]=t;
			}		
		}
	}
}

int main(){
	int arr[10]={2,3,5,7,2,1,8,9,4};
	int n=9;
	
	{//print
		int i;	
		for(i=0;i<n;i++){ printf(" %d",arr[i]); }
		printf("\n");
	}
	
	SORT(arr,n);
	
	{//print
		int i;	
		for(i=0;i<n;i++){ printf(" %d",arr[i]); }
		printf("\n");
	}
	
	return 0;
}
