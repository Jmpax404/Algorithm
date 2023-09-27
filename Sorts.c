#include <stdio.h>
#include <stdlib.h> 
#include <time.h>
#include <math.h>

//#define SORT bubbleSort
//#define SORT selectSort
//#define SORT insertSort
//#define SORT mergeSort
//#define SORT mergeSortIter
#define SORT randomQuickSort

const int MAX_N = 100;

int partition(int arr[], int s, int e){
	int p=(int)round((rand() * 1.0 / RAND_MAX) * (e-s) + s);
	int t=arr[p];
	arr[p]=arr[s];
	arr[s]=t;
	int l=s;
	int r=e;
	while(l<r){
		while(l<r && arr[r]>t){ r--; }
		arr[l]=arr[r];		
		while(l<r && arr[l]<=t){ l++; }
		arr[r]=arr[l];
	}
	arr[l]=t;
	return l;
}

void randomQuickSortPriv(int arr[],int s,int e){
	if(s<e){
		int pos = partition(arr,s,e);
		randomQuickSortPriv(arr,s,pos-1);
		randomQuickSortPriv(arr,pos+1,e);	
	}
}

void randomQuickSort(int arr[],int n){
	printf("randomQuickSort:\n");
	randomQuickSortPriv(arr,0,n-1);
}

void merge(int arr[],int s1,int e1,int s2,int e2){
	int i=s1;
	int j=s2;
	int tarr[MAX_N];
	int tn=0;
	while(i<=e1 && j<=e2){
		if(arr[i]<=arr[j]){
			tarr[tn++]=arr[i++];
		}else{
			tarr[tn++]=arr[j++];
		}
	}
	while(i<=e1){ tarr[tn++]=arr[i++]; }
	while(j<=e2){ tarr[tn++]=arr[j++]; }
	int k;
	for (k=0;k<tn;k++){
		arr[s1+k]=tarr[k];
	}
}

void mergeSortIter(int arr[],int n){
	printf("mergeSortIter:\n");
	int i,j;
	for(i=2;i/2<n;i*=2){
		for(j=0;j<n;j+=i){
			int mid = j+i/2;
			if(mid<n){
				merge(arr,j,mid-1,mid, (int)fmin(j+i-1,n-1) );	
			}	
		}
	}
}

void mergeSortPriv(int arr[],int s,int e){
	if(s<e){
		int mid=(s+e)/2;
		mergeSortPriv(arr,s,mid);
		mergeSortPriv(arr,mid+1,e);
		merge(arr,s,mid,mid+1,e);
	}
}

void mergeSort(int arr[],int n){
	printf("mergeSort:\n");
	mergeSortPriv(arr,0,n-1);
}

void insertSort(int arr[],int n){
	printf("insertSort:\n");
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
	printf("selectSort:\n");
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
	printf("bubbleSort:\n");
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
	srand((unsigned)time(NULL));
	
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
