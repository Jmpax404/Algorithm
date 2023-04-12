#include <stdio.h>

int insert(int arr[],int n,int val){
	int i,j;
	for(i=0;i<n;i++){
		if(arr[i] > val){
			break;
		}
	}
	for(j=n-1;j>=i;j--){
		arr[j+1]=arr[j];
	}
	arr[i]=val;
	return i;
}

int main(){
	int arr[10]={1,3,5,7,8,10};
	int n=6;
	int testVal=11;
	int index = insert(arr,n,testVal); 
	n++;
	printf(">>>%d\n",index);
	int i;
	for(i=0;i<n;i++){
		printf(" %d",arr[i]);
	}
	
	return 0;
}
