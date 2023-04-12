#include <stdio.h>
#include <string.h>	

int main(){
	int a[3][3]={3};
	int *p = **a;
	printf("%p",p);
	return 0;
}



//	int arr[10]={1,2,3,4,5,6,7,8};
//	memset(arr,0,sizeof(arr));
//	printf("%d\n",arr[6]);
