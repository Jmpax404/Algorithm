#include <stdio.h>

#define MAX_INT 100000000

int main(){
	const int n=10;
	int i;
	int arr[n];
	int maxVal = -MAX_INT;
	int minVal = MAX_INT;
	int maxPos=-1;
	int minPos=-1;
	int t;
	for(i=0;i<n;i++){
		scanf("%d",&t);
		arr[i] = t;
		if(t>maxVal){
			maxVal=t;
			maxPos=i;
		}//using 'else if' is wrong
		if (t<minVal){
			minVal=t;
			minPos=i;
		}
	}
	t=maxVal;
	arr[maxPos]=arr[minPos];
	arr[minPos]=t;
	for(i=0;i<n;i++){
		printf(" %d",arr[i]);
	}
	return 0;
}
