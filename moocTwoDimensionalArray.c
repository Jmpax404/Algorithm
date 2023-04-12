#include <stdio.h>
#define L 4

int main(){
	int arr[3][L]={ 1,2,3,4,5,6,7,8,9,10,11,12 };
	int i=2, j=3;
	printf("%p %p %p %p\n",
		arr,arr[0],&arr[0],&arr[0][0]);//they are the same.
	
	int (*p1)[L]=arr;// =&arr[0]=arr
	printf("%d %d %d %d %d\n",
		arr[i][j],p1[i][j],*(p1[i]+j),*(*(p1+i)+j), (*(p1+i))[j]
	);
	
	int *p2=*arr;// =&arr[0][0]=arr[0]=*arr
	printf("%d %d %d\n",
		arr[i][j],p2[i*L+j],*(p2+i*L+j)
	);
	return 0;
}
