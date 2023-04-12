#include <stdio.h>

const int N = 30;
int fibs[N+1]={0,1,1};

int main(){
	for(int i = 3;i<=N;i++){
		fibs[i]=fibs[i-1]+fibs[i-2];
	}
	int m,n;
	scanf("%d",&m);
	int t1,t2;
	for(int i = 0;i<m;i++){
		scanf("%d",&n);
		for(int j=0;j<n;j++){
			t1=2*(n-j-1);
			t2=j*2;
			for(int k=0;k<t1;k++){
				printf(" ");
			}
			for(int k=0;k<t2;k++){
				printf("%d ",fibs[k]);
			}
			printf("%d\n",fibs[t2]);
		}
	}
	return 0;
}
