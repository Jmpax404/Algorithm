#include <stdio.h> 
#define N 100

void FindSaddlePoint(int a[][N], int m, int n){
	int i,j,k;
	int maxV,maxI;
	for(i=0;i<m;i++){
		maxV=a[i][0];
		maxI=0;
		for(j=1;j<n;j++){
			if(a[i][j]>maxV){
				maxV=a[i][j];
				maxI=j;
			}
		}
		int faultFlag=0;
		for(k=0;k<m;k++){
			if(a[k][maxI]<maxV){
				faultFlag=1;
				break;	
			}
		}
		if(!faultFlag){
			printf("a[%d][%d] is %d\n",i,maxI,maxV);
			return;
		}
	}
	printf("No saddle point!\n");
}

int main(){
	int m,n;
	printf("Input m,n:\n");
	scanf("%d,%d",&m,&n);
	printf("Input matrix:\n");
	int arr[N][N];
	int i,j;
	for(i=0;i<m;i++){
		for(j=0;j<n;j++){
			scanf("%d",&arr[i][j]);
		}
	}
	FindSaddlePoint(arr,m,n);
	return 0;
}
