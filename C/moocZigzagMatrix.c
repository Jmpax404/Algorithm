#include <stdio.h>
#define N 100


void ZigzagMatrix(int a[][N],int n){
	int i,j,k;
	int c=1;
	for(i=0;i<n;i++){
		if(i%2){
			for(k=0,j=i;j>=0;j--,k++){
				a[k][j]=c++;
			}
		}else{
			for(k=i,j=0;j<=i;j++,k--){
				a[k][j]=c++;
			}
		}
	}
	c=n*n;
	for(i=n-1;i>=1;i--){
		if((n-i)%2){
			for(k=i,j=n-1;k<n;j--,k++){
				a[k][j]=c--;
			}	
		}else{
			for(k=n-1,j=i;j<n;j++,k--){
				a[k][j]=c--;
			}
		}
	}
}

int inputN(){
	int n;
	if(scanf("%d",&n)!=1){
		return 0;
	}
	if(n>100 || n<=0){
		return 0;
	}
}

int main(){
	int n=inputN();
	if(n==0){
		printf("Input error!\n");
		return 0;
	}
	int matrix[N][N]={0};
	ZigzagMatrix(matrix, n);
	//printf
	int i,j;
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			printf("%3d",matrix[i][j]);
		}
		printf("\n");
	}
	return 0;
}
