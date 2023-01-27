#include <stdio.h>

# define N 7

int main(){
	int arr[N][N]={0};
	int i,j;
	for(i=0;i<N;i++){
		arr[i][0]=1;	
	}
	printf("%-4d\n",arr[0][0]);
	for(i=1;i<N;i++){
		for(j=0;j<=i;j++){
			arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
			printf("%-4d",arr[i][j]);
		}
		printf("\n");
	}
	return 0;
}
