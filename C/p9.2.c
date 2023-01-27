#include <stdio.h>

void swap(int *a, int *b){
	int t=*a;
	*a=*b;
	*b=t;
}

void findMaxAndMin(int arr[],int n,int *pMaxIndex,int *pMinIndex){
	int maxIndex,minIndex;
	int maxVal,minVal;
	maxVal=minVal=arr[maxIndex=minIndex=0];
	int i,t;
	for(i=1;i<n;i++){
		t=arr[i];
		if(t>maxVal){
			maxVal=t;
			maxIndex=i;
		}
		if(t<minVal){
			minVal=t;
			minIndex=i;
		}
	}
	*pMaxIndex=maxIndex;
	*pMinIndex=minIndex;
}

int main(){
	const int n=10;
	int i;
	int arr[n];
	for(i=0;i<n;i++){
		scanf("%d",&arr[i]);
	}
	int maxIndex,minIndex;
	findMaxAndMin(arr,n,&maxIndex,&minIndex);
	swap(&arr[maxIndex],&arr[minIndex]);
	for(i=0;i<n;i++){
		printf(" %d",arr[i]);
	}
	printf("\n");
}



//9.2
//	int a[10]={1,2,3,4,5,6,7,8,9,0};
//	int b[10]={0,9,8,7,6,5,4,3,2,1};
//	int n = 10;
//	int i;
//	for(i=0;i<n;i++){
//		swap(&a[i],&b[i]);
//	}
//	for(i=0;i<n;i++){
//		printf(" %d",a[i]);
//	}
//	printf("\n");
//	for(i=0;i<n;i++){
//		printf(" %d",b[i]);
//	}
//	printf("\n");
//	return 0;
