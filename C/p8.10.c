#include <stdio.h>

#define MAX_COL 16

int inputMatrix(int matrix[][MAX_COL]){
	int n;
	scanf("%d",&n);
	int i,j;
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			scanf("%d",&matrix[i][j]);
		}
	}
	return n;
}

int diagonalSum(int matrix[][MAX_COL],int n){
	int i,j;
	int sum=0;
	for(i=0,j=n-1;i<n;i++,j--){
		sum+=matrix[i][i]+matrix[i][j];
	}
	if(n%2){
		sum-=matrix[n/2][n/2];
	}
	return sum;
}

int main(){
	int matrix[MAX_COL][MAX_COL];
	int n = inputMatrix(matrix);
	int sum = diagonalSum(matrix,n);
	printf("%d\n",sum);
	return 0;
}
