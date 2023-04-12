#include <stdio.h>
#include <stdlib.h>

int findMax(int *p, int m, int n, int *pRow, int *pCol){
	int max=0xFFFFFFFF;
	int row=-1,col=-1;
	int i,j,t;
	for(i=0;i<m;i++){
		for(j=0;j<n;j++){
			t=p[i*n+j];
			if(t>max){
				max=t;
				row=i;
				col=j;
			}
		}
	}
	*pRow=row;
	*pCol=col;
	return max;
}

int *inputMatrix(int *pm, int *pn){
	scanf("%d",pm);
	scanf("%d",pn);
	int m=*pm,n=*pn;
	int *arr = (int *)calloc(m*n,sizeof(int));
	if(arr==NULL){
		return NULL;
	}
	int i,j;
	for(i=0;i<m;i++){
		for(j=0;j<n;j++){
			scanf("%d",arr+i*n+j);
		}
	}
	return arr;
}

int main(){
	int m,n;
	int *arr = inputMatrix(&m, &n);
	if(arr==NULL){
		printf("Memory full!\n");
		return 0;
	}
	int row, col;
	int res = findMax(arr,m,n,&row,&col);
	printf("[%d,%d] %d\n",row,col,res);
	free(arr);
	return 0;
}

//11.6
//#define M 10
//#define N 10
//
//int findMax(int *p, int m, int n, int *pRow, int *pCol){
//	int max=0xFFFFFFFF;
//	int row=-1,col=-1;
//	int i,j,t;
//	for(i=0;i<m;i++){
//		for(j=0;j<n;j++){
//			t=p[i*N+j];
//			if(t>max){
//				max=t;
//				row=i;
//				col=j;
//			}
//		}
//	}
//	*pRow=row;
//	*pCol=col;
//	return max;
//}
//
//void inputMatrix(int a[][N], int *pm, int *pn){
////	printf("Row Count: ");
//	scanf("%d",pm);
////	printf("Col Count: ");
//	scanf("%d",pn);
//	int i,j;
//	int m=*pm,n=*pn;
////	printf("please input the matrix:\n");
//	for(i=0;i<m;i++){
//		for(j=0;j<n;j++){
//			scanf("%d",&a[i][j]);
//		}
//	}
//}
//
//void printMatrix(int a[][N], int m, int n){
//	int i,j;
//	printf("Matrix:\n");
//	for(i=0;i<m;i++){
//		for(j=0;j<n;j++){
//			printf("%d ",a[i][j]);
//		}
//		printf("\n");
//	}
//}
//
//int main(){
//	int m,n;
//	int arr[M][N];
//	inputMatrix(arr, &m, &n);
//	int row, col;
//	int res = findMax(arr,m,n,&row,&col);
//	printf("[%d,%d]%d\n",row,col,res);
//	return 0;
//}



//11.5 
//void traspose(int (*a)[N], int (*at)[M], int m, int n){
//	int i,j;
//	for(i=0;i<m;i++){
//		for(j=0;j<n;j++){
////			at[j][i]=a[i][j];//ok
//			*(*(at+j)+i) = *(*(a+i)+j);
//		}
//	}
//}
//
//	int m,n;
//	int arr[M][N],arrt[N][M];
//	inputMatrix(arr, &m, &n);
//	traspose(arr,arrt,m,n);
//	printMatrix(arrt,n,m);
//	return 0;



//11.4
//void swap(int *pa,int *pb){
//	int t=*pa;
//	*pa=*pb;
//	*pb=t; 
//}
//
//void traspose(int *a,int n){
//	int i,j;
//	for(i=1;i<n;i++){
//		for(j=0;j<i;j++){
//			swap(a+N*i+j,a+N*j+i);
//		}
//	}
//}
//
//int main(){
//	int n;
//	scanf("%d",&n);
//	int i,j;
//	int arr[N][N];
//	for(i=0;i<n;i++){
//		for(j=0;j<n;j++){
//			scanf("%d",&arr[i][j]);
//		}
//	}
//	traspose(arr,n);
//	printf("Result: \n");
//	for(i=0;i<n;i++){
//		for(j=0;j<n;j++){
//			printf("%d ",arr[i][j]);
//		}
//		printf("\n");
//	}
//	return 0;
//}
