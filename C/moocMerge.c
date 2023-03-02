#include <stdio.h>
#define N 100

void Merge(int a[], int b[], int c[], int m, int n){
	int i,j,k;
	i=j=k=0;
	while(1){
		while(i<m && a[i]>=b[j]){ c[k++]=a[i++]; }
		if(i==m){
			while(j<n){ c[k++]=b[j++]; }
			break;
		}
		while(j<n && a[i]<b[j]){ c[k++]=b[j++]; }
		if(j==n){
			while(i<m){ c[k++]=a[i++]; }
			break;
		}
	}
}

int main(){
	int m,n;
	scanf("%d %d",&m,&n);
	int i;
	int a1[N],a2[N];
	for(i=0;i<m;i++){
		scanf("%d",&a1[i]);
	}
	for(i=0;i<n;i++){
		scanf("%d",&a2[i]);
	}
	int c[N];
	Merge(a1,a2, c, m, n);
	for(i=0;i<n+m;i++){
		printf(" %d",c[i]);
	}
	return 0;
}
