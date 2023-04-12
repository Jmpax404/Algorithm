#include <stdio.h>

#define N 30

void visit(int a[], bool v[], int n, int i, int *total, int *count){
	(*total)+=a[i];
	v[i]=true;
	if(*total<40){
		for(int j=i+1;j<n;j++){
			visit(a,v,n,j,total,count);
		}
	}else if(*total==40){
		(*count)++;
	}
	v[i]=false;
	(*total)-=a[i];
}

int main(){
	int n;
	scanf("%d",&n);
	int a[N];
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	bool v[N];
	int total=0;
	int count=0;
	for(int i=0;i<n;i++){
		visit(a,v,n,i,&total,&count);
	}
	printf("%d\n",count);
	return 0;
}
